package pt.isel.leic.lae

import pt.isel.leic.lae.logger.Logger

data class Info(val num : Int, var name : String)

data class User(val username : String, var password : String)

fun main() {
	Logger.log(null)
	Logger.log("ISEL")
	Logger.log(Info(12345, "Fernando Pessoa"))
	Logger.log(Info(23456, "Afonso Henriques"))
	
	Logger.log(User("fpessoa", "pessoa1888"))
	
	val hmap = java.util.HashMap<Int, String>()
	hmap.put(12345, "Fernando Pessoa")
	hmap.put(23456, "Afonso Henriques")
	
	Logger.log(hmap)
}
