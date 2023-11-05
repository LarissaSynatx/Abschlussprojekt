open class Held(var name: String,var hp: Int,var waffe: String,var atk: Int,var schild: Boolean,var besiegt: Boolean = false) {
    val maxHp: Int = hp
    var verflucht: Boolean = false

    open fun basicAtk(gegner: Gegner) {
        val schaden= 10+atk
        println("$name greift ${gegner.name} an und verursacht $schaden Schaden!")
        Thread.sleep(300)
        gegner.hp -= schaden
        println("Die Lebenspunkte liegen jetzt bei ${gegner.hp} HP.")
    }

    fun beutel(beutel: Beutel) {
        println("Wähle einen Trank..")
        beutel.inhalt()
        var input = readln().toInt()

        while (input !in 1..2) {
            println("Ungültige Eingabe, versuche es erneut..")
            input = readln().toInt()
        }
        when (input) {
            1 -> {
                beutel.inhalt.filterIsInstance<Heiltrank>().first().anzahl -= 1 // überarbeiten, zieht keinen Trank ab nach auswahl..
                hp += 50
                println("$name hat den Heiltrank gewählt." +
                            " Seine Lebenspunkte sind jetzt bei $hp HP.")
            }
            2 -> {
                beutel.inhalt.filterIsInstance<Powertrank>().first().anzahl -= 1
                atk += 20
                println("$name hat den Powertrank gewählt." +
                            " Seine Angriffspunkte sind jetzt bei $atk ATK.")
            }
        }
//        if (input==1){
//            hp += 50
//            println("$name hat den Heiltrank gewählt." +
//                    " Seine Lebenspunkte sind jetzt bei $hp HP.")
//        }else{
//            atk += 20
//            println("$name hat den Powertrank gewählt." +
//                        " Seine Angriffspunkte sind jetzt bei $atk ATK.")
//        }
//    }
    }
    fun besiegt(){
        besiegt = true
    }
    override fun toString(): String {
        return name
//        return "$name, $hp HP, $waffe, $atk ATK, Schild: $schild"
    }
}