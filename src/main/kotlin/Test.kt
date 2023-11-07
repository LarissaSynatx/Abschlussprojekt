fun main() {
    val druide = Druide("Alderwood", 600, "Stab", 100, false, false)
    val zwerg = Zwerg("Gimli", 600, "Axt", 100, true, false)
    val dunkelelfe = Dunkelelfe("Lilithra", 700, "Gurthang-Schwert", 100, "Dolch", false, false)
    val helden: MutableList<Held> = mutableListOf(druide, zwerg, dunkelelfe)

    val beutel = Beutel()

    val endgegner = Endgegner("Icy", 1000, "Eis-Hammer", 100)
    val gehilfe = Gehilfe("Stormy", 400, "Dolch", 100)
    val gegner: MutableList<Gegner> = mutableListOf(endgegner)


    println("Der Krieg des Schicksals: Die Eishexe erwacht")
    Thread.sleep(500)
    println("-- -- -- -- -- -- -- --")
    Thread.sleep(500)
    println("Drücke 1 um das Spiel zu starten")
    Thread.sleep(500)
    println("Drücke 2 um mehr über dein Team zu erfahren")
    var input = readln().toInt()
    when (input) {
        1 -> {
            println("Das Spiel wird startet..")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(1000)
        }

        2 -> {
            println("Dein Team: ")
            for (i in helden)
                i.info()
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
            println("Drücke 1 um das Spiel zu starten..")
            val input2 = readln().toInt()
            if (input2 == 1) {
                println("Das Spiel wird startet..")
                Thread.sleep(500)
                println("-- -- -- -- -- -- -- --")
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
            if ((endgegner.hp <= 0 && !gehilfe.beschworen) || (gehilfe.beschworen && gehilfe.hp <= 0 && endgegner.hp <= 0)) {
                println("Deine Helden haben gewonnen!")
                break
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
            if ((endgegner.hp <= 0 && !gehilfe.beschworen) || (gehilfe.beschworen && gehilfe.hp <= 0 && endgegner.hp <= 0)) {
                println("Deine Helden haben gewonnen!")
                break
            }

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

            if ((endgegner.hp <= 0 && !gehilfe.beschworen) || (gehilfe.beschworen && gehilfe.hp <= 0 && endgegner.hp <= 0)) {
                println("Deine Helden haben gewonnen!")
                break
            }

            if (endgegner.hp > 0) {
                endgegner.angriff(helden,gegner,gehilfe)
            }
            if (gehilfe.beschworen) {
                gehilfe.angriff(helden)
            }

            beutelCounter = 0
            if (druide.maxHp <= 0) {
                druide.besiegt()
                println("${druide.name} wurde besiegt!")
            }
            if (zwerg.maxHp <= 0) {
                zwerg.besiegt()
                println("${zwerg.name} wurde besiegt!")
            }
            if (dunkelelfe.maxHp <= 0) {
                dunkelelfe.besiegt()
                println("${dunkelelfe.name} wurde besiegt!")
            }
            if (helden.all { it.maxHp == 0 }) {
                println("Icy hat gewonnen!")
                break
            }
            runde++
        }

    }


}