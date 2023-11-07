class Druide(name: String, maxHp: Int, waffe: String, atk: Int, schild: Boolean, besiegt: Boolean) : Held(name, maxHp, waffe, atk, schild,besiegt) {
    fun feuerzauber(gegner: MutableList<Gegner>) {
        val gegner = auswahlGegnerTeam(gegner)
        val schaden = (40..80).random() + atk
        println("$name wirft einen Feuerzauber auf ${gegner.name}!")
        Thread.sleep(1000)
        println("${gegner.name} fängt an zu brennen und erleidet $schaden Schaden!")
        Thread.sleep(1000)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
        Thread.sleep(500)
    }

    fun heilzauber(helden: MutableList<Held>) {
        val heilen = auswahl(helden)
        heilen!!.maxHp += 20
        println("$heilen wurde geheilt!")
        Thread.sleep(1000)
        println("Die Lebenspunkte liegen jetzt bei ${heilen!!.maxHp} HP.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
    }

    fun schutzzauber() {
        println("$name beschwört mit seinem Schutzzauber ein Schild, bevor der Angriff des Gegners ihn trifft und verringert damit den Schaden!")
        Thread.sleep(500)
        schild = true
    }

    fun verwandlungszauber(gegner: MutableList<Gegner>) {
        val gegner = auswahlGegnerTeam(gegner)
        val schaden = 50 + atk
        println(
            "$name's Atem wird schwer und tief, sein Körper beginnt zu zittern, und seine Haut nimmt eine tiefere, erdige Farbe an. " +
                    " Seine Augen leuchten wie smaragdgrüne Juwelen, und seine Finger krümmen sich zu mächtigen Klauen." +
                    " Der Druide wurde zu einem mächtigen Bären und stürzt sich auf ${gegner.name}!"
        )
        Thread.sleep(1000)
        println("Mit seinem Angriff verursacht $name $schaden Schaden!")
        Thread.sleep(1000)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
    }
    fun angriff(endGegner: Endgegner, gegner: MutableList<Gegner>, helden: MutableList<Held>) {
        if (verflucht && hp > maxHp * 0.2) {
            val schaden = maxHp * 0.1
            hp - schaden
            println("Durch den Fluch von ${endGegner.name} hat $name $schaden HP verloren.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        }
        if (verflucht && hp < maxHp * 0.2) {
            verflucht = false
            endGegner.flüche = 0
            println("Der Fluch ist abgelaufen und verursacht keinen Schaden mehr")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        }
        if (!besiegt){
            println("$name ist bereit zu kämpfen!")
            Thread.sleep(1000)
            println("Wie möchtest du angreifen..?")
            Thread.sleep(1000)
            println("1 für Feuerzauber")
            Thread.sleep(500)
            println("2 für Heilzauber")
            Thread.sleep(500)
            println("3 für Schutzzauber")
            Thread.sleep(500)
            println("4 für Verwandlungszauber")
            val input = readln().toInt()
            println("Du hast dich für Attacke $input entschieden.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
            when(input) {
                1 -> feuerzauber(gegner)
                2 -> heilzauber(helden)
                3 -> schutzzauber()
                4 -> verwandlungszauber(gegner)
            }
        } else println("$name wurde bereits besiegt..!")
    }
}

