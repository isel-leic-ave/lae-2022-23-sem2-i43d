val seq = sequence {
	yield(1734)
	yield(2122)
	println("meio")
	yield(3897)
	yield(4234)
}

fun main() {
	for (n in seq) {
		println(n)
	}
}
