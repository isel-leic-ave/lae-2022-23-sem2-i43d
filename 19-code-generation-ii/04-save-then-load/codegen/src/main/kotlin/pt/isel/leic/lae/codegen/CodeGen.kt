package pt.isel.leic.lae.codegen

import org.cojen.maker.*

import java.io.*
import java.net.URLClassLoader

import kotlin.reflect.full.staticFunctions

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
 * In the end, the .class file is loaded and its main method is invoked via reflection.
 */

const val CLASS_NAME = "HelloCojenMaker"
const val HELLO_MSG = "Hello, generated world!"

fun main(args: Array<String>) {

	//////////////////////////////////
	//
	// STEP 0 : Create the output directory
	//

	val outputDirName =
		if (args.count() > 0) args[0] else "../output"
	
	val outputDir = File(outputDirName)
	outputDir.mkdirs()


	//////////////////////////////////
	//
	// STEP 1 : Generate code
	//

	println(":: Generating code")

	val classMaker = generateCode(CLASS_NAME, HELLO_MSG)

	println(":: Generated $CLASS_NAME code")


	//////////////////////////////////
	//
	// STEP 2 : Save the .class file
	//

	val classFile = File(outputDir, "$CLASS_NAME.class")

	println(":: Saving $CLASS_NAME.class")
	saveCodeToClassFile(classMaker, classFile)
	

	//////////////////////////////////
	//
	// STEP 3 : Load the new class
	//

	val classLoader = URLClassLoader.newInstance(arrayOf(outputDir.toURI().toURL()))

	println(":: Loading $CLASS_NAME.class")
	val klass = classLoader.loadClass(CLASS_NAME).kotlin	


	//////////////////////////////////
	//
	// STEP 5 : RUN
	//

	println(":: Finding $CLASS_NAME.main")
	@Suppress("UNCHECKED_CAST")
	val mainMethod = klass.staticFunctions.first {
		method -> method.name == "main"
	} as (Array<String>) -> Unit

	println(":: RUNNING\n")
	mainMethod.invoke(arrayOf())
}

fun generateCode(className: String, message: String) : ClassMaker {

	val cm : ClassMaker =
		ClassMaker.beginExternal(className).public_()

	// public static void main(String[] args)...
	val mm : MethodMaker = cm.addMethod(null, "main", Array<String>::class.java).public_().static_()

	// System.out.println(...
	mm.`var`(System::class.java).field("out").invoke("println", message)

	return cm
}

fun saveCodeToClassFile(classMaker: ClassMaker, classFile: File) {
	classFile.createNewFile()
	FileOutputStream(classFile, false).use { fileStream -> classMaker.finishTo(fileStream) }
}
