class Endgegner(name: String, hp: Int, waffe: String, atk: Int): Schurke(name,hp,waffe,atk) {
    fun unsichtbar(helden: MutableList<Held>) {
        val held = helden.random()
        if(!held.schild){
            val schaden= 50+atk
            println("$name hat sich unsichtbar gemacht und greift nun hinterrücks ${held.name} an!")
            Thread.sleep(500)
            println("$name hat $schaden Schaden verursacht!")
            held.hp -= schaden
            println("Die Lebenspunkte liegen jetzt bei ${held.hp} HP.")
        } else {
            val schaden = 25+atk
            println("$name hat sich unsichtbar gemacht und greift nun hinterrücks ${held.name} an!")
            Thread.sleep(500)
            println("Doch ${held.name} kommt $name zuvor und schützt sich in letzter Sekunde mit seinem Schild!")
            Thread.sleep(300)
            println("Durch ${held.name} Schild hat sich der Schaden um die hälfte verringert!")
        }
    }
    fun eisatem() {

    }
    fun schneesturm() {

    }
    fun beschwörungszauber() {

    }
}