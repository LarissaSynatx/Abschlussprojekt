class Dunkelelfe(name: String, maxHp: Int, waffe: String, atk: Int, var zweitwaffe: String, schild: Boolean, besiegt: Boolean) :
    Held(name, maxHp, waffe, atk, schild,besiegt) {
    fun feenfeuer(gegner: MutableList<Gegner>) {
        val gegner = auswahlGegnerTeam(gegner)
        val schaden = 80 + atk
        println("$name erhebt ihre Hände und beschwört ihre Mächte. Plötzlich entzünden sich ihre Fingerspitzen in einem düsteren Feenfeuer.")
        Thread.sleep(1000)
        println("Eine unheilvolle Aura umgibt sie, und ihre Augen funkeln.. Mit einer geschickten Bewegung schleudert sie das Feenfeuer auf ${gegner.name}!")
        Thread.sleep(1000)
        println("Ein finsterer Schein erhellt den Kampf, während ${gegner.name} in Schmerz und Verwirrung gerät.")
        Thread.sleep(1000)
        println("$name hat ${gegner.name} $schaden Schaden zugefügt!")
        Thread.sleep(1000)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)

    }

    fun dunkelheit(gegner: MutableList<Gegner>) {
        val gegner = auswahlGegnerTeam(gegner)
        val schaden = 70 + atk
        println("$name beschwört die Macht der Dunkelheit. Ihre Augen glühen in einem unheimlichen Schimmer, während sie die Finsternis um sich herum verstärkt.")
        Thread.sleep(1000)
        println("Die Dunkelheit verdichtet sich und legt sich wie ein undurchdringlicher Schleier über ${gegner.name}..")
        Thread.sleep(1000)
        println("$name nutzt diese Chance, zieht ihr tödliches Schwert und schleicht sich lautlos an ihre blindes Opfer heran.")
        Thread.sleep(1000)
        println("Mit einem blitzschnellen und präzisen Schlag durchschneidet $name die Finsternis und trifft ${gegner.name} mit ihrem $waffe.")
        Thread.sleep(1000)
        println("$name hat ${gegner.name} $schaden Schaden zugefügt!")
        Thread.sleep(1000)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)

    }

    fun beideWaffen(gegner: MutableList<Gegner>) {
        val gegner = auswahlGegnerTeam(gegner)
        val schaden = (50..80).random() + atk
        println("$name zieht ihre Klingen, mit flinken Bewegungen bereitet sie sich auf ihren Angriff vor.")
        Thread.sleep(1000)
        println("Ihre Augen glühen bedrohlich..")
        Thread.sleep(1000)
        println("Mit einem rasanten Doppelschwertangriff wirbelt $name durch die Menge. Die Schwerter verschmelzen zu einem tödlichen Tanz, während sie blitzschnell zuschlägt!")
        Thread.sleep(1000)
        println("${gegner.name} hat keine Chance gegen die Geschwindigkeit und die Präzision der Dunkelelfe. Sie wird von allen Seiten attackiert und taumeln rückwärts, während $name unerbittlich zuschlägt.")
        Thread.sleep(1000)
        println("$name hat ${gegner.name} $schaden Schaden zugefügt!")
        Thread.sleep(1000)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
    }
    fun angriff(endGegner: Endgegner, gegner: MutableList<Gegner>, helden: MutableList<Held>) {
        if (verflucht && hp > maxHp * 0.2) {
            val schaden = maxHp * 0.1
            hp - schaden
            println("Durch den Fluch von ${endGegner.name} hat $name $schaden HP verloren.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        }
        if (verflucht && hp < maxHp * 0.2) {
            verflucht = false
            endGegner.flüche = 0
            println("Der Fluch ist abgelaufen und verursacht keinen Schaden mehr")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
        }
        if (!besiegt){
            println("$name ist bereit zu kämpfen!")
            Thread.sleep(1000)
            println("Wie möchtest du angreifen..?")
            Thread.sleep(1000)
            println("1 für Feenfeuer")
            Thread.sleep(500)
            println("2 für Dunkelheit")
            Thread.sleep(500)
            println("3 für Beide Waffen")
            Thread.sleep(500)
            println("4 für Basic-Attacke")
            val input = readln().toInt()
            println("Du hast dich für Attacke $input entschieden.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
            when(input){
                1 -> feenfeuer(gegner)
                2 -> dunkelheit(gegner)
                3 -> beideWaffen(gegner)
                4 -> basicAtk(gegner)
            }
        } else println("$name wurde bereits besiegt..!")
    }
    override fun info(){
        println("$name, $maxHp HP, $waffe, Zweitwaffe: $zweitwaffe, $atk ATK, Schild: $schild")
    }
}