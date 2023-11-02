class Dunkelelfe(name: String, hp: Int, waffe: String, atk: Int, var zweitwaffe: String, schild: Boolean) :
    Held(name, hp, waffe, atk, schild) {
    fun feenfeuer(gegner: Gegner) {
        val schaden = 80 + atk
        println("$name erhebt ihre Hände und beschwört ihre Mächte. Plötzlich entzünden sich ihre Fingerspitzen in einem düsteren Feenfeuer.")
        Thread.sleep(500)
        println("Eine unheilvolle Aura umgibt sie, und ihre Augen funkeln.. Mit einer geschickten Bewegung schleudert sie das Feenfeuer auf ${gegner.name}!")
        Thread.sleep(500)
        println("Ein finsterer Schein erhellt den Kampf, während ${gegner.name} in Schmerz und Verwirrung gerät.")
        Thread.sleep(500)
        println("$name hat ${gegner.name} $schaden Schaden zugefügt!")
        Thread.sleep(500)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
    }

    fun dunkelheit(gegner: Gegner) {
        val schaden = 70 + atk
        println("$name beschwört die Macht der Dunkelheit. Ihre Augen glühen in einem unheimlichen Schimmer, während sie die Finsternis um sich herum verstärkt.")
        Thread.sleep(500)
        println("Die Dunkelheit verdichtet sich und legt sich wie ein undurchdringlicher Schleier über ${gegner.name}..")
        Thread.sleep(500)
        println("$name nutzt diese Chance, zieht ihr tödliches Schwert und schleicht sich lautlos an ihre blindes Opfer heran.")
        Thread.sleep(500)
        println("Mit einem blitzschnellen und präzisen Schlag durchschneidet $name die Finsternis und trifft ${gegner.name} mit ihrem $waffe.")
        Thread.sleep(500)
        println("$name hat ${gegner.name} $schaden Schaden zugefügt!")
        Thread.sleep(500)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
    }

    fun beideWaffen(gegner: Gegner) {
        val schaden = (50..80).random() + atk
        println("$name zieht ihre Klingen, mit flinken Bewegungen bereitet sie sich auf ihren Angriff vor.")
        Thread.sleep(500)
        println("Ihre Augen glühen bedrohlich..")
        Thread.sleep(500)
        println("Mit einem rasanten Doppelschwertangriff wirbelt $name durch die Menge. Die Schwerter verschmelzen zu einem tödlichen Tanz, während sie blitzschnell zuschlägt!")
        Thread.sleep(500)
        println("${gegner.name} hat keine Chance gegen die Geschwindigkeit und die Präzision der Dunkelelfe. Sie wird von allen Seiten attackiert und taumeln rückwärts, während $name unerbittlich zuschlägt.")
        Thread.sleep(500)
        println("$name hat ${gegner.name} $schaden Schaden zugefügt!")
        Thread.sleep(500)
        gegner.hp -= schaden
        println("Die Lebenspunkte von ${gegner.name} liegen jetzt bei ${gegner.hp} HP.")
    }
}