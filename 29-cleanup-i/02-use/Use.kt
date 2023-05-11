import java.io.*

const val tmpdir = "lae-tmp"
val dir = File(tmpdir)

fun prepare() {
	dir.mkdir()
}

fun demo() {
	val file = File(dir, "output.txt")
	file.printWriter().use { output ->
		
		output.println("ISEL")
		output.println("LEIC")
		output.println("LAE")
	
	}
}

fun main() {
	prepare()
	demo()
	
	println(":: done ::")
	Thread.sleep(20000)
	
	System.gc()
	
	println(":: GC ::")
	Thread.sleep(20000)
}