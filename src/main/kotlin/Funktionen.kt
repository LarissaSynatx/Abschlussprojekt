
fun auswahl(helden:MutableList<Held>): Held?{
    println("Auf welchen deiner Kameraden möchtest du die Aktion anwenden?")
    println(helden)
    val input = readln()
    while (input != "Alderwood" && input != "Gimli" && input != "Lilithra" ){
        println("Ungültige Eingabe..versuche es erneut!")
    }
    return helden.find { it.name == input }
}
