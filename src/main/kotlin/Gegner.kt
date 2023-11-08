open class Gegner(open var name: String, open var hp: Int, var waffe: String, var atk: Int) {
    var beschworen: Boolean = false
    open fun basicAtk(helden: MutableList<Held>) {
        val held = helden.random()
        if (!held.schild) {
            val schaden = 10 + atk
            println("$name greift ${held.name} mit ihrem $waffe an und verursacht $schaden Schaden!")
            Thread.sleep(500)
            held.hp -= schaden
            println("Die Lebenspunkte von ${held.name} liegen jetzt bei ${held.hp} HP.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        } else {
            val schaden = 5 + atk
            held.hp -= schaden
            println("$name setzt zu einem Schlag an!")
            Thread.sleep(500)
            println("Doch durch ${held.name}'s Schild hat sich der Schaden um die hälfte verringert!")
            Thread.sleep(500)
            println("Schaden: $schaden")
            Thread.sleep(500)
            println("Die Lebenspunkte von ${held.name} liegen jetzt bei ${held.hp} HP.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        }
    }

    open fun powerAtk(helden: MutableList<Held>) {
        val held = helden.random()
        if (!held.schild) {
            val schaden = 25 + atk
            println("$name führt einen heftige Powerattacke gegen ${held.name} aus und verursacht $schaden Schaden!")
            Thread.sleep(500)
            held.hp -= schaden
            println("Die Lebenspunkte von ${held.name} liegen jetzt bei ${held.hp} HP.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        } else {
            val schaden = 12 + atk
            held.hp -= schaden
            println("$name führt einen heftige Powerattacke gegen ${held.name} aus!")
            Thread.sleep(500)
            println("Doch durch ${held.name}'s Schild hat sich der Schaden verringert!")
            Thread.sleep(500)
            println("Schaden: $schaden")
            Thread.sleep(500)
            println("Die Lebenspunkte von ${held.name} liegen jetzt bei ${held.hp} HP.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        }
    }
    fun besiegt(){
        println("$name wurde besiegt!")
    }
}