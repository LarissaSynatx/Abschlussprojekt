open class Schurke(open var name: String,open var hp: Int, var waffe: String,var atk: Int) {

    open fun basicAtk(held: Held) {
        val schaden = 10+atk
        println("$name greift ${held.name} an und verursacht $schaden Schaden!")
        Thread.sleep(300)
        held.hp -= schaden
        println("Die Lebenspunkte liegen jetzt bei ${held.hp} HP.")
    }
    open fun powerAtk(held: Held) {
        val schaden= 25+atk
        println("$name führt einen heftige Powerattacke gegen ${held.name} aus und verursacht $schaden Schaden!")
        Thread.sleep(300)
        held.hp -= schaden
        println("Die Lebenspunkte liegen jetzt bei ${held.hp} HP.")
    }
}