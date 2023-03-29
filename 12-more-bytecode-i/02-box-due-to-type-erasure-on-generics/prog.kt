import java.util.HashMap

fun main() {
	val map = HashMap<Int, String>()
	
	map.put(1234, "Fernando Pessoa")   // autobox for 1234
	map.put(2345, "Afonso Henriques")  // autobox for 2345

	val person = map.get(1234)         // autobox for 1234; cast for return value

	println(person)
}
