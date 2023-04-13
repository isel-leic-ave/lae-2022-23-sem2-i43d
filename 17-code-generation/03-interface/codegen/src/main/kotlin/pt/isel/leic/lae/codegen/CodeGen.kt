package pt.isel.leic.lae.codegen

import java.io.*
import org.cojen.maker.*

/*
 * Create a class implementing Runnable.
 * 
 * public class #SomeName# implements Runnable {
 *   // Empty constructor (calls super(), which is Object.<init>)
 *   public #SomeName#() { }
 *
 *   @Override
 *   public void run()
 *     System.out.println("Hello, generated world!");
 *   }
 * }
 *
 * An instance is then created and assigned to a variable of type Runnable.
 * 
 * Finally, the instance method 'run' is invoked directly (not via reflection).
 *
 */

fun main() {
	val clsm : ClassMaker = ClassMaker.beginExternal("Hello").public_().implement(Runnable::class.java)

	// constructor
	val ctrm : MethodMaker = clsm.addConstructor().public_()

	// public void run()...
	val mthm : MethodMaker = clsm.addMethod(null, "run").public_().override()

	// System.out.println(...
	mthm.`var`(System::class.java).field("out").invoke("println", "Hello, generated world!")

	val clazz = clsm.finish()

	val obj = clazz.getConstructor().newInstance() as Runnable

	obj.run()
}
