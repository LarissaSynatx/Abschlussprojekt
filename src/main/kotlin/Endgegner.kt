import kotlin.random.Random

class Endgegner(name: String, hp: Int, waffe: String, atk: Int) : Gegner(name, hp, waffe, atk) {
    var flüche = 1
    fun unsichtbar(helden: MutableList<Held>) {
        val held = helden.random()
        if (!held.schild) {
            val schaden = 50 + atk
            println("$name hat sich unsichtbar gemacht und greift nun hinterrücks ${held.name} an!")
            Thread.sleep(600)
            println("$name hat $schaden Schaden verursacht!")
            held.maxHp -= schaden
            println("Die Lebenspunkte liegen jetzt bei ${held.maxHp} HP.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        } else {
            val schaden = 25 + atk
            println("$name hat sich unsichtbar gemacht und greift nun hinterrücks ${held.name} an!")
            Thread.sleep(600)
            println("Doch ${held.name} kommt $name zuvor und schützt sich in letzter Sekunde mit seinem Schild!")
            Thread.sleep(500)
            println("Durch ${held.name}'s Schild hat sich der Schaden um die hälfte verringert!")
            Thread.sleep(300)
            println("Verringerter Schaden: $schaden")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
            held.maxHp -= schaden
            held.schild = false
        }
    }

    fun eisatem(helden: MutableList<Held>) {
        val held = helden.random()
        if (!held.schild) {
            val schaden = 70 + atk
            println("$name holt tief Luft und entfesselt einen eisigen Atem!")
            Thread.sleep(500)
            held.maxHp -= schaden
            println("${held.name} bekommt einen heftigen Frostschaden ab!")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        } else {
            val schaden = 35 + atk
            println("$name holt tief Luft und entfesselt einen eisigen Atem!")
            Thread.sleep(500)
            println("Doch ${held.name} kommt $name zuvor und schützt sich in letzter Sekunde mit seinem Schild vor dem eisigen Atem!")
            Thread.sleep(500)
            println("Durch ${held.name}'s Schild hat sich der Schaden um die hälfte verringert!")
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
            Thread.sleep(500)
            held.maxHp -= schaden
            held.schild = false
        }
    }

    fun schneesturm(helden: MutableList<Held>) {
        val held = helden
        val schaden = (30..60).random() + atk
        println("Ein unheilvoller Schauer überzieht den Himmel..")
        Thread.sleep(1000)
        println("$name hat einen Schneestrum entfesselt und greift $held an!")
        Thread.sleep(1000)
        println("Eisige Winde schneiden durch die Luft, und der Schnee wird zu gefrorenen Nadeln, die wie brennende Klingen in die Haut der Helden eindringen.")
        Thread.sleep(1000)
        println("Ihre Sicht wird von wirbelnden Schneemassen beeinträchtigt. Die Helden können sich kaum noch bewegen..")
        Thread.sleep(1000)
        println("Inmitten des tobenden Schneesturms steht $name und lächelt grausam, während sie die verzweifelten Bemühungen der Helden beobachtet.")
        Thread.sleep(1000)
        for (i in helden.indices) {
            helden[i].maxHp -= schaden
        }
        println("$name hat bei allen einen Schaden von $schaden verursacht!")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
    }

    fun beschwörungszauber(gegner: MutableList<Gegner>, gehilfe: Gehilfe){
        if(!gehilfe.beschworen){
            println("$name erhebt ihren mächtigen Hammer, während ihre Augen in eisigem Glanz erstrahlen.")
            Thread.sleep(1000)
            println("Vor den materialisiert sich eine Gestalt aus reinem Eis und Nebel, ihre Konturen sind undeutlich und verändern sich ständig." +
                    " $name hat ihre Gehilfin beschwören..")
            Thread.sleep(1000)
            println("${gehilfe.name} ist nun bereit, ihren verhängnisvollen Befehlen zu folgen..die Kälte, die von ihr ausgeht, ist beunruhigend spürbar.. ")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
            gegner.add(gehilfe)
            gehilfe.beschworen = true
        } else {
            println("$name hat den Zauber in dieser Runde bereits gesprochen..")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        }
    }

fun fluch(helden: MutableList<Held>) {
    val held = helden.random()
    if (!held.verflucht && flüche == 1) {
        held.verflucht = true
        println("$name hebt ihren eiskalten Blick auf ${held.name} und beginnt, uralte Fluchformeln zu murmeln..")
        Thread.sleep(1000)
        println("Ein dunkler Schleier der Verdammnis senkt sich über ${held.name}, und sein Gesicht verzieht sich vor Qual.")
        Thread.sleep(1000)
        println("$name hat einen grausamen und unbarmherzigen Fluch ausgesprochen! ${held.name} ist jetzt verflucht!")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
    } else {
        println("$name kann in dieser Runde keinen weiteren Fluch wirken, da bereits ein Held verflucht ist.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
    }
}

    fun angriff(helden: MutableList<Held>,gegner: MutableList<Gegner>,gehilfe: Gehilfe) {
        val randomAngriff = Random.nextInt(1,7)
        when(randomAngriff){
            1 -> unsichtbar(helden)
            2 -> eisatem(helden)
            3 -> schneesturm(helden)
            4 -> beschwörungszauber(gegner,gehilfe)
            5 -> basicAtk(helden)
            6 -> powerAtk(helden)
            7 -> fluch(helden)
        }
    }
}
