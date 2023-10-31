open class Held(var name: String,var hp: Int,var waffe: String,var atk: Int,var schild: Boolean) {

    open fun basicAtk(schurke: Schurke) {
        val schaden= 10+atk
        println("$name greift ${schurke.name} an und verursacht $schaden Schaden!")
        Thread.sleep(300)
        schurke.hp -= schaden
        println("Die Lebenspunkte liegen jetzt bei ${schurke.hp} HP.")
    }

    fun beutel(beutel: Beutel) {
        println(
            "Wähle einen Trank.." +
                    "1 für einen Heiltrank" +
                    " oder 2 für einen Powertrank"
        )
        var input = readln().toInt()

        while (input !in 1..2) {
            println("Ungültige Eingabe, versuche es erneut..")
            input = readln().toInt()
        }
        when (input) {
            1 -> {
                beutel.heiltrank -= 1
                hp += 50
                println("$name hat den Heiltrank gewählt." +
                            " Seine Lebenspunkte sind jetzt bei $hp HP.")
            }
            2 -> {
                beutel.powertrank -= 1
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
}