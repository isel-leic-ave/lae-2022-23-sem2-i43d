package pt.isel.leic.lae.codegen

import java.io.*
import org.cojen.maker.*

fun main() {
	val cm : ClassMaker = ClassMaker.begin().public_()

	// public static void run()...
	val mm : MethodMaker = cm.addMethod(null, "run").public_().static_()

	// System.out.println(...
	mm.`var`(System::class.java).field("out").invoke("println", "Hello, generated world!")

	val clazz : Class<*> = cm.finish()
	clazz.getMethod("run").invoke(null)
}
