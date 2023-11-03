import kotlin.random.Random

class Endgegner(name: String, hp: Int, waffe: String, atk: Int) : Gegner(name, hp, waffe, atk) {
    private var gehilfe = 1

    fun unsichtbar(helden: MutableList<Held>) {
        val held = helden.random()
        if (!held.schild) {
            val schaden = 50 + atk
            println("$name hat sich unsichtbar gemacht und greift nun hinterrücks ${held.name} an!")
            Thread.sleep(600)
            println("$name hat $schaden Schaden verursacht!")
            held.hp -= schaden
            println("Die Lebenspunkte liegen jetzt bei ${held.hp} HP.")
        } else {
            val schaden = 25 + atk
            println("$name hat sich unsichtbar gemacht und greift nun hinterrücks ${held.name} an!")
            Thread.sleep(600)
            println("Doch ${held.name} kommt $name zuvor und schützt sich in letzter Sekunde mit seinem Schild!")
            Thread.sleep(500)
            println("Durch ${held.name}'s Schild hat sich der Schaden um die hälfte verringert!")
            Thread.sleep(300)
            println("Verringerter Schaden: $schaden")
            held.hp -= schaden
            held.schild = false
        }
    }

    fun eisatem(helden: MutableList<Held>) {
        val held = helden.random()
        if (!held.schild) {
            val schaden = 70 + atk
            println("$name holt tief Luft und entfesselt einen eisigen Atem!")
            Thread.sleep(500)
            held.hp -= schaden
            println("${held.name} bekommt einen heftigen Frostschaden ab!")
        } else {
            val schaden = 35 + atk
            println("$name holt tief Luft und entfesselt einen eisigen Atem!")
            Thread.sleep(500)
            println("Doch ${held.name} kommt $name zuvor und schützt sich in letzter Sekunde mit seinem Schild vor dem eisigen Atem!")
            Thread.sleep(500)
            println("Durch ${held.name}'s Schild hat sich der Schaden um die hälfte verringert!")
            held.hp -= schaden
            held.schild = false
        }
    }

    fun schneesturm(helden: MutableList<Held>) {
        val held = helden
        val schaden = (30..60).random() + atk
        println("$name hat einen Schneestrum entfesselt und greift $helden an!") //lösung für die namen in der Liste finden
        Thread.sleep(500)
        println("Ihnen wird eiskalt und sie können durch den Schneestrum nichts mehr sehen..!")
        Thread.sleep(500)
        for (i in helden.indices) {
            helden[i].hp -= schaden
        }
        println("$name hat bei allen einen Schaden von $schaden verursacht!")
    }

    fun beschwörungszauber() {
        if (gehilfe > 0) {
            println("$name beschwört ihre Gehilfin..")
            gehilfe = 0
        } else println("$name hat den Zauber in dieser Runde bereits gesprochen..")
    }
    fun fluch(helden: MutableList<Held>) {
        val held = helden.random()
        held.verflucht = true
        println("$name hat ${held.name} verflucht..!")
    }
//    val schaden = (held.hp * 0.1).toInt()
//    held.hp -= schaden
//    println("$name hat ${held.name} $schaden HP abgezogen!" +
//    " Die Lebenspunkte von ${held.name} liegen jetzt bei ${held.hp} HP.")
//private  var flüche = 3
    fun angriff(helden: MutableList<Held>) {
        val randomAngriff = Random.nextInt(1,7)
        when(randomAngriff){
            1 -> unsichtbar(helden)
            2 -> eisatem(helden)
            3 -> schneesturm(helden)
            4 -> fluch(helden)
            5 -> basicAtk(helden)
            6 -> powerAtk(helden)
            7 -> beschwörungszauber()
        }
    }
}
