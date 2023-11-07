open class Gegner(open var name: String, open var hp: Int, var waffe: String, var atk: Int) {
    var beschworen: Boolean = false
    open fun basicAtk(helden: MutableList<Held>) {
        val held = helden.random()
        if (!held.schild) {
            val schaden = 10 + atk
            println("$name greift ${held.name} mit ihrem $waffe an und verursacht $schaden Schaden!")
            Thread.sleep(500)
            held.maxHp -= schaden
            println("Die Lebenspunkte von ${held.name} liegen jetzt bei ${held.maxHp} HP.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        } else {
            val schaden = 5 + atk
            println("$name setzt zu einem Schlag an!")
            Thread.sleep(500)
            println("Doch durch ${held.name}'s Schild hat sich der Schaden($schaden) um die hälfte verringert!")
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
            held.maxHp -= schaden
            println("Die Lebenspunkte von ${held.name} liegen jetzt bei ${held.maxHp} HP.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        } else {
            val schaden = 12 + atk
            println("$name führt einen heftige Powerattacke gegen ${held.name} aus!")
            Thread.sleep(500)
            println("Doch durch ${held.name}'s Schild hat sich der Schaden($schaden) verringert!")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        }
    }
}