
fun <T> Iterable<T>.inspect(inspector: (T) -> Unit) : Iterable<T> {
	return object : Iterable<T> {
		override fun iterator() : Iterator<T> {
			val source = this@inspect.iterator()
			return object : Iterator<T> {
				override fun hasNext() : Boolean = source.hasNext()
				override fun next() : T {
					val item = source.next()
					inspector(item)
					return item
				}
			}
		}
	}
}

private enum class IteratorState {
	NotReady, Ready, Done
}

fun <T> Iterable<T>.where(predicate : (T) -> Boolean) : Iterable<T> {
	return object : Iterable<T> {
		override fun iterator() : Iterator<T> {
			val source = this@where.iterator()
			return object : Iterator<T> {
				private var state = IteratorState.NotReady
				private var curr : T? = null

				override fun hasNext() : Boolean =
					tryAdvance() == IteratorState.Ready

				override fun next() : T {
					if (tryAdvance() == IteratorState.Done) {
						throw NoSuchElementException()
					}
					val res = curr
					curr = null
					state = IteratorState.NotReady
					return res ?: throw Exception("Invalid state")
				}
				
				private fun tryAdvance() : IteratorState {
					if (state == IteratorState.NotReady) {
						state = IteratorState.Done
						while (source.hasNext()) {
							val item = source.next()
							if (predicate(item)) {
								curr = item
								state = IteratorState.Ready
								break
							}
						}
					}
					return state
				}
			}
		}
	}
}

fun <T,R> Iterable<T>.select(mapper: (T) -> R) : Iterable<R> {
	return object : Iterable<R> {
		override fun iterator() : Iterator<R> {
			val source = this@select.iterator()
			return object : Iterator<R> {
				override fun hasNext() : Boolean = source.hasNext()
				override fun next() : R = mapper(source.next())
			}
		}
	}
}

fun <T> Iterable<T>.lookup(predicate: (T) -> Boolean) : T? {
	for (item in this) {
		if (predicate(item)) {
			return item
		}
	}
	return null
}

data class Person(val id: Int, val name: String, val birthYear: Int)

fun main() {
	val inputData = listOf(
		Person(10000, "Afonso Henriques", 1109),
		Person(11000, "Inês de Castro", 1325),
		Person(12000, "Nuno Álvares Pereira", 1360),
		Person(14000, "Luís de Camões", 1524),
		Person(13000, "Vasco da Gama", 1469),
		Person(15000, "Josefa de Óbidos", 1630),
		Person(16000, "Fernando Pessoa", 1888)
	)
	
	val outputData =
		inputData
			.inspect { println("1>> $it") }
			.where   { it.birthYear > 1500 }
			.inspect { println("2>> $it") }
			.select  { it.name }
			.inspect { println("3>> $it") }
			.lookup  { it[0] == 'J' }
	
	println(outputData)
}
