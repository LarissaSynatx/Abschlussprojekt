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

    fun heilzauber(held: Held) {
        println("Welchen deiner Kameraden soll $name heilen?")

    }

    fun schutzzauber(schurke: Schurke) {
//        val schadenAbfangen =
    }

    fun verwandlungszauber() {

    }
}