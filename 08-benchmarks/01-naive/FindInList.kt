val listOfWords = listOf(
	"Alfa", "Bravo", "Charlie", "Delta", "Echo",
	"Foxtrot", "Golf", "Hotel", "India", "Juliett",
	"Kilo", "Lima",	"Mike", "November", "Oscar", "Papa",
	"Quebec", "Romeo", "Sierra", "Tango",	"Uniform",
	"Victor", "Whiskey", "X-ray", "Yankee", "Zulu")

//
// == Method to be benchmarked ==
//
fun doesMikeExist() = listOfWords.contains("Mike")

const val N = 10
const val R = 1000000
val times = LongArray(N+1) { 0 }

fun main() {
	println(":: MEASURING ::")
	times[0] = System.nanoTime()
	for (n in 1..N) {    // ## Number of iterations                ##
		for (r in 1..R)    // ## Number of repetitions per iteration ##
			doesMikeExist()  // ## Method being benchmarked            ##
		times[n] = System.nanoTime()
	}
	println(":: DONE ::")
	
	// ## Result for each iteration ##
	for (n in 1..N) {
		println("t$n : ${(times[n]-times[n-1])*1.0/R}ns")
	}
}
