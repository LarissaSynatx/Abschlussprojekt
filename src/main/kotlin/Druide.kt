class Druide(name: String,hp: Int,waffe: String,atk: Int,schild: Boolean):Held(name,hp,waffe,atk,schild) {
    fun feuerzauber(schurke: Schurke) {
        val schaden = (40..80).random() + atk
        println("$name wirft einen Feuerzauber auf ${schurke.name}!")
        Thread.sleep(500)
        println("${schurke.name} fängt an zu brennen und erleidet $schaden Schaden!")
        Thread.sleep(500)
        schurke.hp -= schaden
        println("Die Lebenspunkte liegen jetzt bei ${schurke.hp} HP.")
    }

    fun heilzauber(held: MutableList<Held>) {
        val heilen = auswahl(held)
        heilen!!.hp += 20
        println("$heilen wurde geheilt!")
        println("Die Lebenspunkte liegen jetzt bei ${heilen!!.hp} HP.")
    }

    fun schutzzauber(schurke: Schurke) {
//        val schadenAbfangen =
    }

    fun verwandlungszauber(held: Held) {
        val schaden = 50
        println("${held.name}'s Atem wird schwer und tief, sein Körper beginnt zu zittern, und seine Haut nimmt eine tiefere, erdige Farbe an. " +
                " Seine Augen leuchten wie smaragdgrüne Juwelen, und seine Finger krümmen sich zu mächtigen Klauen." +
                " Der Druide wurde zu einem mächtigen Bären und stürzt sich auf den Angreifer!")

    }
}