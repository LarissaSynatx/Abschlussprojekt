class Zwerg(name: String, hp: Int, waffe: String, atk: Int, schild: Boolean):Held(name,hp,waffe,atk,schild) {
    fun jumpAndHit(gegner: Gegner) {
        val schaden = (60..90).random() + atk
        println("Mit einem mächtigen Sprung stürzt $name sich auf seinen Gegner von oben herab und landet mit einem gewaltigen Schlag!")
        Thread.sleep(500)
        println("Ein lautes Klirren erklingt, als seine $waffe den Feind trifft, und ein Funkenregen sprüht umher.")
        Thread.sleep(500)
        println("$name hat ${gegner.name} $schaden Schaden zugefügt!")
        Thread.sleep(500)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
    }
    fun spinAndHit(gegner: Gegner) {
        val schaden = 50 + atk
        println("$name setzt zum beeindruckenden Spin-Angriff an!")
        Thread.sleep(500)
        println("Mit einem lauten Kriegsschrei wirbelt er wie ein Wirbelwind herum, seine mächtige $waffe schneidet durch die Luft.")
        Thread.sleep(500)
        println("$name treibt durch seinen Angriff ${gegner.name} in die Ecke und greift sie an!")
        Thread.sleep(500)
        println("$name trifft ${gegner.name} mit seiner Axt und fügt Ihr $schaden Schaden zu!")
        Thread.sleep(500)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
    }
   fun schildBlock(gegner: Gegner) {
       println("$name hebt sein Schild und macht sich für den nächsten Angriff von ${gegner.name} bereit!")
       schild = true
    }
}