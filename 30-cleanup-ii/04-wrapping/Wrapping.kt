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

}

fun demoGood() {
	OutputFile("output-good.txt").use { output ->
		output.writeln("ISEL")
		output.writeln("LEIC")
		output.writeln("LAE")
	}
}

fun demoBad() {
	val output = OutputFile("output-bad.txt")
	
	output.writeln("ISEL")
	output.writeln("LEIC")
	output.writeln("LAE")

}

fun main() {
	demoGood()
	demoBad()
	
	println(":: done ::")
	Thread.sleep(10000)
	
	System.gc()
	
	println(":: GC ::")
	Thread.sleep(10000)
}
