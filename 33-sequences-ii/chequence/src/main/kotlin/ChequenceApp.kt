package pt.isel.leic.lae

fun demo1_sequence() {
	val seq = sequence {
		println(":: Starting ::")
		yield(7)

		println(":: Step 1 ::")
		yield(6)

		println(":: Step 2 ::")
		yield(5)

		println(":: Done ::")
	}

	seq.forEach(::println)
}

fun demo1_chequence() {
	val seq = chequence {{ label ->
		when (label) {
			0 -> {
				println(":: Starting ::")
				yield(7, 1)
			}
			1 -> {
				println(":: Step 1 ::")
				yield(6, 2)
			}
			2 -> {
				println(":: Step 2 ::")
				yield(5, 3)
			}
			3 -> {
				println(":: Done ::")
			}
		}
	}}

	seq.forEach(::println)
}

fun demo1() {
	println("## Demo 1 : Sequence ##")
	demo1_sequence()
	println()
	println("## Demo 1 : Chequence ##")
	demo1_chequence()
	println()
}

fun demo2_sequence() {
	val seq = sequence {
		yield(7)
		throw Exception("Exception inside sequence")
	}

	try {
		seq.forEach(::println)
	} catch (exc: Exception) {
		println("Exception: ${ exc.message }")
	}
}

fun demo2_chequence() {
	val seq = chequence {{ label ->
		when (label) {
			0 -> yield(7, 1)
			1 -> throw Exception("Exception inside chequence")
		}
	}}

	try {
		seq.forEach(::println)
	} catch (exc: Exception) {
		println("Exception: ${ exc.message }")
	}
}

fun demo2() {
	println("## Demo 2 : Sequence ##")
	demo2_sequence()
	println()
	println("## Demo 2 : Chequence ##")
	demo2_chequence()
	println()
}

fun demo3_sequence() {
	val seq = sequence {
		var terms = Pair(0, 1)
		
		while (true) {
			yield(terms.first)
			terms = Pair(terms.second, terms.first + terms.second)
		}
	}

	println(seq.take(8).toList())
}

fun demo3_chequence() {
	val seq = chequence {
		lateinit var terms : Pair<Int,Int>;
		{ label ->
			when (label) {
				0 -> {
					terms = Pair(0, 1)
					yield(terms.first, 1)
				}
				1 -> {
					terms = Pair(terms.second, terms.first + terms.second)
					yield(terms.first, 1)
				}
			}
		}
	}

	println(seq.take(8).toList())
}

fun demo3() {
	println("## Demo 3 : Sequence ##")
	demo3_sequence()
	println()
	println("## Demo 3 : Chequence ##")
	demo3_chequence()
	println()
}

fun main() {
	demo1()
	demo2()
	demo3()
}
