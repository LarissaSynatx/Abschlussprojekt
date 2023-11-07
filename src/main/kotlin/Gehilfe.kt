import kotlin.random.Random

class Gehilfe(name: String, hp: Int, waffe: String, atk: Int) : Gegner(name, hp, waffe, atk) {
    fun anschleichen(helden: MutableList<Held>) {
        val held = helden.random()
        val schaden = 50 + atk
        println(
            "Im Schatten der Dunkelheit bewegt sich $name geräuschlos.. " +
                    "$name's Schritte sind kaum hörbar, und  nähert sich unbemerkt ${held.name}."
        )
        Thread.sleep(1000)
        println(
            "Plötzlich taucht $name aus dem Dunkel auf und ihr $waffe blitzt gefährlich. Ein blitzschneller Angriff! " +
                    " Sie zielt auf eine verletzliche Stelle und sticht zu!"
        )
        Thread.sleep(1000)
        println("Der Schmerzensschrei von ${held.name} erfüllt die Luft, während der Dolch tief eindringt.")
        Thread.sleep(1000)
        println("Der Überraschungsangriff von $name ist hinterhältig und gefährlich und hat $schaden Schaden verursacht!")
        Thread.sleep(1000)
        held.maxHp -= schaden
        println("Die Lebenspunkte von ${held.name} liegen jetzt bei ${held.maxHp} HP.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
    }

    private fun stehlen(beutel: Beutel) {
        beutel.inhalt.random().anzahl -= 1
        println("Es wurde ein Trank gestohlen..")
        Thread.sleep(500)
        println(beutel.inhalt)
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
    }
    fun angriff(helden: MutableList<Held>) {
        val randomAngriff = Random.nextInt(1,5)
        when(randomAngriff){
            1 -> anschleichen(helden)
            2 -> stehlen(Beutel())
            3 -> basicAtk(helden)
            4 -> powerAtk(helden)
        }
    }
}

