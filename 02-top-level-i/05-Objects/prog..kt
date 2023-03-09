object AnObject {
	var value = 0
	
	fun mao() {
		println("AnObject(value: ${value})")
	}
}

fun main() {
	AnObject.value++
	AnObject.mao()
}
