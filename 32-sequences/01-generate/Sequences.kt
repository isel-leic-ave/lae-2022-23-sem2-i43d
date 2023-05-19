import kotlin.random.Random

fun demoSeqOf() {
	val seqInt1to9 = sequenceOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
	val seqStrAtoU = sequenceOf("A", "E", "I", "O", "U")

	println(seqInt1to9.toList())
	println(seqStrAtoU.toList())
	
	val intSeq = seqInt1to9.onEach { println("19>> $it") }.take(3)
	println(intSeq.toList())

	val chr =
		seqStrAtoU.onEach { println("AU>> $it") }.drop(2).first()
	println(chr)
}

fun demoGenSeq() {
	val rnds = generateSequence { Random.nextInt() }
	//rnds.forEach { println(it) }
	
	val nums = rnds.take(10).toList()
	println(nums)
	
	val oddSeq = generateSequence(1) { it + 2 }
	
	val oddNums = oddSeq.drop(50).take(8).toList()
	println(oddNums)
}

fun demoYield() {
	val nums = sequence {
		var x = 1
		yield(x++)
		yield(x)
		yieldAll(listOf(3, 4, 5))
		println("... antes do for ...")
		for (i in 6..9) {
			println("... iteração $i ...")
			yield(i)
		}
		yield(10)
	}
	
	println(nums.take(7).toList())
}

fun main() {
	demoSeqOf()
	demoGenSeq()
	demoYield()
}
