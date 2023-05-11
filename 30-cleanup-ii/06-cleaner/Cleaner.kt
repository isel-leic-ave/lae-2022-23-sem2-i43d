import java.lang.ref.*
import java.io.*

class OutputFile(val fname : String) : Closeable {

	private companion object {
		const val tmpdir = "lae-tmp"
		val dir = File(tmpdir)
		init {
			dir.mkdir()
		}
		val cleaner = Cleaner.create()
		init {
			println(":: Cleaner created ::")
			println(cleaner)
		}
	}

	private class CleanableState(val writer : PrintWriter) : Runnable {
		override fun run() {
			println("cleaning")
			writer.close()
		}
	}

	private val file = File(dir, fname)
	private val state = CleanableState(file.printWriter())
	private val cleanable = cleaner.register(this, state)

	fun writeln(txt : String) { state.writer.println(txt) }
	fun write(txt : String)   { state.writer.print(txt)   }
	
	override fun close() {
		println("closing")
		cleanable.clean()
	}
}

fun demoGood() {
	OutputFile("output-with-use.txt").use { output ->
		output.writeln("ISEL")
		output.writeln("LEIC")
		output.write("LAE")
	}
}

fun demoBad() {
	val output = OutputFile("output-without-use.txt")
	output.writeln("ISEL")
	output.writeln("LEIC")
	output.writeln("LAE")
}

fun main() {

	demoGood()
	demoBad()
	
	println(":: done ::")
	Thread.sleep(8000)
	
	System.gc()
	
	println(":: GC ::")
	Thread.sleep(8000)
}
