class Druide(name: String, hp: Int, waffe: String, atk: Int, schild: Boolean) : Held(name, hp, waffe, atk, schild) {
    fun feuerzauber(gegner: Gegner) {
        val schaden = (40..80).random() + atk
        println("$name wirft einen Feuerzauber auf ${gegner.name}!")
        Thread.sleep(1000)
        println("${gegner.name} fängt an zu brennen und erleidet $schaden Schaden!")
        Thread.sleep(1000)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
    }

    fun heilzauber(held: MutableList<Held>) {
        val heilen = auswahl(held)
        heilen!!.hp += 20
        println("$heilen wurde geheilt!")
        println("Die Lebenspunkte liegen jetzt bei ${heilen!!.hp} HP.")
    }

    fun schutzzauber(gegner: Gegner) {
        println("$name beschwört mit seinem Schutzzauber ein Schild, bevor der Angriff von ${gegner.name} ihn trifft und verringert damit den Schaden!")
        schild = true
    }

    fun verwandlungszauber(gegner: Gegner) {
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
    }
    fun angriff(gegner: Gegner,helden: MutableList<Held>) {
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
        println("Du hast dich für $input entschieden.")
        Thread.sleep(1000)
        when(input){
            1 -> feuerzauber(gegner)
            2 -> heilzauber(helden)
            3 -> schutzzauber(gegner)
            4 -> verwandlungszauber(gegner)
        }
    }
}