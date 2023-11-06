fun main() {
    val druide = Druide("Alderwood", 600, "Stab", 100, false, false)
    val zwerg = Zwerg("Gimli", 600, "Axt", 100, true, false)
    val dunkelelfe = Dunkelelfe("Lilithra", 700, "Gurthang-Schwert", 100, "Dolch", false, false)
    val helden: MutableList<Held> = mutableListOf(druide, zwerg, dunkelelfe)

    val endgegner = Endgegner("Icy", 1000, "Hammer", 100)
//    val gehilfe = Gehilfe("Stormy", 400, "Dolch", 100) !!!!! Muss noch der Liste hinzugefügt werden!!!!
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
            for (i in helden)
                i.info()
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
    if (input == 1) {
        var runde: Int = 1
        var beutelCounter = 0
        while (true) {
            println("Runde $runde hat begonnen..")
            Thread.sleep(500)
            println(
                "Drücke 1 um anzugreifen" +
                        " Drücke 2 um in den Beutel zuschauen"
            )
            val input1 = readln().toInt()
            when (input1) {
                1 -> druide.angriff(gegner, helden)
                2 -> {
                    druide.beutel(beutel)
                    beutelCounter++
                }
            }

            if (beutelCounter < 1) {
                println(
                    "Drücke 1 um anzugreifen" +
                            " Drücke 2 um in den Beutel zuschauen"
                )
                val input2 = readln().toInt()
                when (input2) {
                    1 -> zwerg.angriff(gegner)
                    2 -> {
                        zwerg.beutel(beutel)
                        beutelCounter++
                    }
                }
            } else zwerg.angriff(gegner)

            if (beutelCounter < 1) {
                println(
                    "Drücke 1 um anzugreifen" +
                            " Drücke 2 um in den Beutel zuschauen"
                )
                val input3 = readln().toInt()
                when (input3) {
                    1 -> dunkelelfe.angriff(gegner)
                    2 -> dunkelelfe.beutel(beutel)
                }
            } else dunkelelfe.angriff(gegner)

            endgegner.angriff(helden)
            beutelCounter = 0

            if (druide.hp <= 0) {
                druide.besiegt()
                println("${druide.name} wurde besiegt!")
            }
            if (zwerg.hp <= 0) {
                zwerg.besiegt()
                println("${zwerg.name} wurde besiegt!")
            }
            if (dunkelelfe.hp <= 0) {
                dunkelelfe.besiegt()
                println("${dunkelelfe.name} wurde besiegt!")
            }
            if (helden.all { it.hp == 0 }) {
                println("Icy hat gewonnen!")
            }
            if (endgegner.hp <= 0) {
                println("Deine Helden haben gewonnen!")
            }
            runde++
        }

    }


}