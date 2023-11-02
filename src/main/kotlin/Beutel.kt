class Beutel(var inhalt: MutableList<Trank> = mutableListOf(Heiltrank(),Powertrank())){
    fun inhalt(){
        var counter = 1
        for (i in inhalt) {
            println("$counter für $i")
            counter++
        }
    }
}