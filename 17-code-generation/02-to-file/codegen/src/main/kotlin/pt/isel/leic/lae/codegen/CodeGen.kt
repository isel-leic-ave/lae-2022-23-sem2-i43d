package pt.isel.leic.lae.codegen

import java.io.*
import org.cojen.maker.*

/*
 * Creates a class with a given name, Hello, and a standard main method:
 * 
 * public class Hello {
 *   public static void main(String[] #arg0#)
 *     System.out.println("Hello, generated world!");
 *   }
 * }
 *
 * The class is then saved into a file, Hello.class, and can be inspected and run with:
 *  - Inspect: javap -c -p output/Hello.class
 *  - Run:     java -cp output Hello
 *
 */

fun main() {
	val cm : ClassMaker = ClassMaker.beginExternal("Hello").public_()

	// public static void main(String[] args)...
	val mm : MethodMaker = cm.addMethod(null, "main", Array<String>::class.java).public_().static_()

	// System.out.println(...
	mm.`var`(System::class.java).field("out").invoke("println", "Hello, generated world!")

	val outputDir = File("../output")
	outputDir.mkdirs()
	
	val classFile = File(outputDir, "Hello.class")
	classFile.createNewFile()

	FileOutputStream(classFile, false).use { fileStream -> cm.finishTo(fileStream) }
}
