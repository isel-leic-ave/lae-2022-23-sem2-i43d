// Autobox when passing primitive for Any

fun main() {
	display("ISEL", 2023)     // autobox from primitive
	display("LAE", "LEIC43D") // no need to box (already an object)
}

fun display(name: String, value: Any?) {
	println("$name: $value")
}

