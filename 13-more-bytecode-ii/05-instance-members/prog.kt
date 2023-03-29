class Msg(private val msg : String) {
	fun show() = println(msg)    // acesso a msg com getfield
}

fun main() {
	val obj = Msg("Hello, world!")
	obj.show()                   // invocação de show com invokevirtual
}
