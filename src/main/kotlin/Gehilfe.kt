import kotlin.random.Random  //(Chatgpt)

class Gehilfe(name: String, hp: Int, waffe: String, atk: Int, var wurdeBeschworen: Boolean = false) :
    Gegner(name, hp, waffe, atk) {

    fun anschleichen(held: Held) {
        val schaden = 50 + atk
        println(
            "Im Schatten der Dunkelheit bewegt sich $name geräuschlos.. " +
                    "$name's Schritte sind kaum hörbar, und  nähert sich unbemerkt ${held.name}."
        )
        Thread.sleep(500)
        println(
            "Plötzlich taucht $name aus dem Dunkel auf und ihr Dolch blitzt gefährlich. Ein blitzschneller Angriff! " +
                    " Sie zielt auf eine verletzliche Stelle und sticht zu!"
        )
        Thread.sleep(500)
        println("Der Schmerzensschrei von ${held.name} erfüllt die Luft, während der Dolch tief eindringt.")
        Thread.sleep(500)
        println("Der Überraschungsangriff von $name ist hinterhältig und gefährlich und hat $schaden Schaden verursacht!")
        Thread.sleep(500)
        held.hp -= schaden
        println("Die Lebenspunkte von ${held.name} liegen jetzt bei ${held.hp} HP.")
    }

    fun stehlen(beutel: Beutel) {
        beutel.inhalt.random().anzahl -= 1
        println("Es wurde ein Trank gestohlen..")
        println(beutel.inhalt)
    }
}

