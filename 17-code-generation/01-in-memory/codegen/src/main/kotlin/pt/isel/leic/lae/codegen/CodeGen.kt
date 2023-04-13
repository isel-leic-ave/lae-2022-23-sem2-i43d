package pt.isel.leic.lae.codegen

import java.io.*
import org.cojen.maker.*

/*
 * Basic example taken from Cojen/Maker documentation.
 * Creates a class with a generated name and a single static method, run:
 * 
 * public class #SomeName# {
 *   public static void run()
 *     System.out.println("Hello, generated world!");
 *   }
 * }
 *
 * The static method run is then invoked via reflection.
 *
 */

fun main() {
	val cm : ClassMaker = ClassMaker.begin().public_()

	// public static void run()...
	val mm : MethodMaker = cm.addMethod(null, "run").public_().static_()

	// System.out.println(...
	mm.`var`(System::class.java).field("out").invoke("println", "Hello, generated world!")

	val clazz : Class<*> = cm.finish()
	clazz.getMethod("run").invoke(null)
}
