open class Held(
    var name: String,
    var maxHp: Int,
    var waffe: String,
    var atk: Int,
    var schild: Boolean,
    var besiegt: Boolean = false
) {
    var hp: Int = maxHp
    var verflucht: Boolean = false


    open fun basicAtk(gegner: MutableList<Gegner>) {
        val gegner = auswahlGegner(gegner)
        val schaden = 10 + atk
        println("$name greift ${gegner.name} an und verursacht $schaden Schaden!")
        Thread.sleep(300)
        gegner.hp -= schaden
        println("Die Lebenspunkte liegen jetzt bei ${gegner.hp} HP.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
        if (gegner.hp <= 0) {
            println("${gegner.name} wurde besiegt..!")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        }
    }

    fun beutel(beutel: Beutel) {
        println("Wähle einen Trank..")
        beutel.inhalt()
        var input = readln().toInt()

        while (input !in 1..2) {
            println("Ungültige Eingabe, versuche es erneut..")
            input = readln().toInt()
        }
        when (input) {
            1 -> {
                beutel.inhalt.filterIsInstance<Heiltrank>().first().anzahl -= 1
                hp += 50
                println(
                    "$name hat den Heiltrank gewählt." +
                            " Seine Lebenspunkte sind jetzt bei $hp HP."
                )
                Thread.sleep(500)
            }

            2 -> {
                beutel.inhalt.filterIsInstance<Powertrank>().first().anzahl -= 1
                atk += 20
                println(
                    "$name hat den Powertrank gewählt." +
                            " Seine Angriffspunkte sind jetzt bei $atk ATK."
                )
                println("-- -- -- -- -- -- -- --")
                Thread.sleep(500)
            }
        }
    }

    fun auswahl(helden: MutableList<Held>): Held? {
        println("Auf welchen deiner Kameraden möchtest du die Aktion anwenden?")
        println(helden)
        var input = readln()
        while (input != "Alderwood" && input != "Gimli" && input != "Lilithra") {
            println("Ungültige Eingabe..versuche es erneut!")
            input = readln()
        }
        return helden.find { it.name == input }
    }

    fun besiegt() {
        besiegt = true
    }

    override fun toString(): String {
        return name
    }

    open fun info() {
        println("$name, $maxHp HP, $waffe, $atk ATK, Schild: $schild")
    }

    fun auswahlGegner(gegnerListe: MutableList<Gegner>): Gegner {
        val gegner = gegnerListe.filter{it.hp>0}
        if (gegner.size < 2) {
            return gegner.first()
        } else {
            println("Welchen deiner Gegner möchtest du angreifen?")
            var counter = 1
            for (i in gegner) {
                println("$counter für ${i.name}")
                counter++
            }
            var input = readln().toInt()
            while (input !in 1..gegner.size) {
                println("Ungültige Eingabe, versuche es erneut..")
                input = readln().toInt()
            }
            return gegner[input - 1]
        }
    }
}