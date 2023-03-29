fun createMessenger(msg : String) : () -> String {
	val extra = "extra(" + msg + ")"

	val theMessenger = {
		println(">> using argument msg and local extra: ")
		println(msg)
		println(extra)
		msg
	}

	println(">> argument msg (\"${msg}\") and local extra about to become invalid")
	return theMessenger
}

fun main() {
	val messenger1 = createMessenger("Hello, LAE!")
	val messenger2 = createMessenger("Hello, LEIC43D!")
	
	println("\n:: messengers created ::\n")
	
	val message1 = messenger1()
	val message2 = messenger2()
	
	println("\n:: messages produced ::\n")

	println(message1)
	println(message2)
}