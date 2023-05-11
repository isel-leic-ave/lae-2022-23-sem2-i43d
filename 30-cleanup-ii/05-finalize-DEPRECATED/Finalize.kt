import java.io.*

class OutputFile(val fname : String) : Closeable {

	private companion object {
		const val tmpdir = "lae-tmp"
		val dir = File(tmpdir)
		init {
			dir.mkdir()
		}
	}

	private val file = File(dir, fname)
	private val output = file.printWriter()
	
	fun writeln(txt : String) { output.println(txt) }
	fun write(txt : String)   { output.print(txt)   }
	
	override fun close() {
		output.close()
	}

	// DO NOT USE AT HOME
	// FINALIZE IS DEPRECATED SINCE JAVA 9
	protected fun finalize() {
		println(">> cleaning <<")
		close()
	}
}

fun demo() {
	val output = OutputFile("output.txt")
	
	output.writeln("ISEL")
	output.writeln("LEIC")
	output.writeln("LAE")
}

fun main() {
	demo()
	
	println(":: done ::")
	Thread.sleep(10000)
	
	System.gc()
	
	println(":: GC ::")
	Thread.sleep(10000)
}
