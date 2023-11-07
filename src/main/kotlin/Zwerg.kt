class Zwerg(name: String, maxHp: Int, waffe: String, atk: Int, schild: Boolean, besiegt: Boolean):Held(name,maxHp,waffe,atk,schild,besiegt) {
    fun jumpAndHit(gegner: MutableList<Gegner>) {
        val gegner = auswahlGegnerTeam(gegner)
        val schaden = (60..90).random() + atk
        println("Mit einem mächtigen Sprung stürzt $name sich auf seinen Gegner von oben herab und landet mit einem gewaltigen Schlag!")
        Thread.sleep(1000)
        println("Ein lautes Klirren erklingt, als seine $waffe den Feind trifft, und ein Funkenregen sprüht umher.")
        Thread.sleep(1000)
        println("$name hat ${gegner.name} $schaden Schaden zugefügt!")
        Thread.sleep(1000)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)

    }

    fun spinAndHit(gegner: MutableList<Gegner>) {
        val gegner = auswahlGegnerTeam(gegner)
        val schaden = 50 + atk
        println("$name setzt zum beeindruckenden Spin-Angriff an!")
        Thread.sleep(1000)
        println("Mit einem lauten Kriegsschrei wirbelt er wie ein Wirbelwind herum, seine mächtige $waffe schneidet durch die Luft.")
        Thread.sleep(1000)
        println("$name treibt durch seinen Angriff ${gegner.name} in die Ecke und greift sie an!")
        Thread.sleep(1000)
        println("$name trifft ${gegner.name} mit seiner Axt und fügt Ihr $schaden Schaden zu!")
        Thread.sleep(1000)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)

    }

    fun schildBlock() {
        println("$name hebt sein Schild und macht sich für den nächsten Angriff des Gegners bereit!")
        Thread.sleep(500)
        println("-- -- -- -- -- -- -- --")
        Thread.sleep(500)
        schild = true
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
            println("1 für Jump and hit")
            Thread.sleep(500)
            println("2 für Spin and hit")
            Thread.sleep(500)
            println("3 für Schildblock")
            Thread.sleep(500)
            println("4 für Basic-Attacke")
            val input = readln().toInt()
            println("Du hast dich für Attacke $input entschieden.")
            Thread.sleep(500)
            println("-- -- -- -- -- -- -- --")
            Thread.sleep(500)
            when(input){
                1 -> jumpAndHit(gegner)
                2 -> spinAndHit(gegner)
                3 -> schildBlock()
                4 -> basicAtk(gegner)
            }
        } else println("$name wurde bereits besiegt..!")
    }
}