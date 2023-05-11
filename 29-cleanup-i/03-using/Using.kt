import java.io.*

inline fun <T : Closeable?, R> T.using(block: (T) -> R): R {
	// over-simplified version
	try {
		return block(this)
	} finally {
		this?.close()
	}
}

const val tmpdir = "lae-tmp"
val dir = File(tmpdir)

fun prepare() {
	dir.mkdir()
}

fun demo() {
	val file = File(dir, "output.txt")
	file.printWriter().using { output ->
		
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