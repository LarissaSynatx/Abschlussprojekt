import kotlin.concurrent.thread

fun main() {
    val druide = Druide("Alderwood", 500, "Stab", 100, false)
    val zwerg = Zwerg("Gimli", 600, "Axt", 100, true)
    val dunkelfee = Dunkelelfe("Lilithra", 700, "Gurthang-Schwert", 100, "Dolch", false)
    val helden: MutableList<Held> = mutableListOf(druide,zwerg,dunkelfee)

    val endgegner = Endgegner("Icy", 1000, "Hammer", 100)
//    val gehilfe = Gehilfe("Stormy", 400, "Dolch", 100)
    val gegner: MutableList<Gegner> = mutableListOf(endgegner)

    val beutel = Beutel()

    println("")// Name Rollenspiel?!
    Thread.sleep(500)
    println("Drücke 1 um das Spiel zu starten")
    Thread.sleep(500)
    println("Drücke 2 um mehr über dein Team zu erfahren")
    var input = readln().toInt()
    when (input) {
        1 -> {
            println("Das Spiel wird startet..")
            Thread.sleep(1000)
        }

        2 -> {
            println("Dein Team: ")
            for (i in helden.indices)
            println(helden[i])
            println("-----------------------------------")
            println("Drücke 1 um das Spiel zu starten..")
            val input2 = readln().toInt()
            if (input2 == 1) {
                println("Das Spiel wird startet..")
                Thread.sleep(500)
                input = 1
            }
        }

    }
    if (input == 1){
        var runde: Int = 1
        while (true){
            println("Runde $runde hat begonnen..")
            Thread.sleep(500)
            druide.angriff(endgegner,helden)
            zwerg.angriff(endgegner)
            dunkelfee.angriff(endgegner)
            endgegner.angriff(helden)
            if (druide.hp == 0) { //fertigstellen! -> Held = tot?!

            }
            if (helden.all { it.hp == 0 }) {
                println("Icy hat gewonnen!")
                break
            } else if (endgegner.hp <= 0) {
                println("Deine Helden haben gewonnen!")
                break
            }
            runde++
        }
        }
    }













//    beutel.inhalt()
//    gegner.filterIsInstance<Gehilfe>().first().stehlen(beutel)
//    gegner.filterIsInstance<Endgegner>().first().schneesturm(helden)
//    val druide = Druide("Alderwood",500,"Stab",100,false)
//    val zwerg = Zwerg("Gimli",600,"Axt",100,true)
//    val dunkelelfe = Dunkelelfe("Lilithra",700,"Gurthang-Schwert",100,"Dolch",false)
//    helden.filterIsInstance<Druide>().first().heilzauber(helden)
//    helden.filterIsInstance<Druide>().first().beutel(beutel)

}