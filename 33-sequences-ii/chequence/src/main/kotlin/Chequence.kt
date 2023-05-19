package pt.isel.leic.lae

import java.lang.IllegalStateException
import java.util.NoSuchElementException

import pt.isel.leic.lae.IteratorState.*

/**
 * Based on code available at:
 * https://github.com/JetBrains/kotlin/blob/master/
 *         libraries/stdlib/src/kotlin/collections/SequenceBuilder.kt
 */

interface ChequenceScope<in T> {
	fun yield(value: T, label: Int)
}

fun <T> chequence(blockMaker: () -> (ChequenceScope<T>.(Int) -> Unit)): Sequence<T> =
	Sequence { ChequenceBuilderIterator<T>(blockMaker()) }

private class ChequenceBuilderIterator<T>(
	private val block: ChequenceScope<T>.(Int) -> Unit
) : ChequenceScope<T>, Iterator<T> {
		
	private var state = NotReady
	private var nextValue : T? = null
	private var nextLabel = 0   // nextLabel and block  replace  nextStep (a Continuation, in the original code)

	override fun yield(value: T, label: Int) {
		nextValue = value
		nextLabel = label
		state = Ready
	}
	
	override fun hasNext() = tryAdvance()
	
	override fun next() : T {
		if (!tryAdvance()) {
			throw NoSuchElementException()
		}
		@Suppress("UNCHECKED_CAST")
		val result = nextValue as T
		nextValue = null
		state = NotReady
		return result
	}
	
	private fun tryAdvance() : Boolean {
		return when (state) {
			Failed -> throw IllegalStateException()
			Done -> false
			Ready -> true
			NotReady -> {
				try {
					state = Done  // stays Done unless block() changes it to Ready or throws
					this.block(nextLabel)  // may change state to Ready
					state != Done
				} catch (exc: Throwable) {
					state = Failed
					throw exc
				}
			}
		}
	}
}

private enum class IteratorState {
	NotReady, Ready, Done, Failed
}
