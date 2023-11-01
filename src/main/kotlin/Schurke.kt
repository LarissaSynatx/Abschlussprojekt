open class Schurke(open var name: String,open var hp: Int, var waffe: String,var atk: Int) {
    val wurdeBeschworen = true //??
    open fun basicAtk(helden: MutableList<Held>) {
        val held = helden.random()
        if (!held.schild) {
            val schaden = 10 + atk
            println("$name greift ${held.name} an und verursacht $schaden Schaden!")
            Thread.sleep(500)
            held.hp -= schaden
            println("Die Lebenspunkte liegen jetzt bei ${held.hp} HP.")
        }else{
            val schaden = 5 + atk
            println("$name setzt zu einem Schlag an!")
            Thread.sleep(500)
            println("Doch durch ${held.name}'s Schild hat sich der Schaden($schaden) um die hälfte verringert!")
        }
    }
    open fun powerAtk(helden: MutableList<Held>) {
        val held = helden.random()
        if (!held.schild) {
            val schaden = 30 + atk
            println("$name führt einen heftige Powerattacke gegen ${held.name} aus und verursacht $schaden Schaden!")
            Thread.sleep(500)
            held.hp -= schaden
            println("Die Lebenspunkte liegen jetzt bei ${held.hp} HP.")
        }else{
            val schaden = 15 + atk
            println("$name führt einen heftige Powerattacke gegen ${held.name} aus!")
            Thread.sleep(500)
            println("Doch durch ${held.name}'s Schild hat sich der Schaden($schaden) um die hälfte verringert!")
        }
    }
}