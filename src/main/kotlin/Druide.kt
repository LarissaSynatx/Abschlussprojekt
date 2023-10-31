class Druide(name: String,hp: Int,waffe: String,atk: Int,schild: Boolean):Held(name,hp,waffe,atk,schild) {
    fun feuerzauber(schurke: Schurke) {
        val schaden = (40..80).random() + atk
        println("$name wirft einen Feuerzauber auf ${schurke.name}!")
        Thread.sleep(300)
        println("${schurke.name} fängt an zu brennen und erleidet $schaden Schaden!")
        Thread.sleep(300)
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

    fun verwandlungszauber() {

    }
}