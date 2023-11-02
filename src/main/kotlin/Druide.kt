class Druide(name: String, hp: Int, waffe: String, atk: Int, schild: Boolean) : Held(name, hp, waffe, atk, schild) {
    fun feuerzauber(gegner: Gegner) {
        val schaden = (40..80).random() + atk
        println("$name wirft einen Feuerzauber auf ${gegner.name}!")
        Thread.sleep(500)
        println("${gegner.name} fängt an zu brennen und erleidet $schaden Schaden!")
        Thread.sleep(500)
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
        Thread.sleep(500)
        println("Mit seinem Angriff verursacht $name $schaden Schaden!")
        Thread.sleep(500)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
    }
}