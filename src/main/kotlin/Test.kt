fun main() {
    val helden: MutableList<Held> = mutableListOf()
    helden.addAll(
        mutableListOf(

            Druide("Alderwood", 500, "Stab", 100, false),
            Zwerg("Gimli", 600, "Axt", 100, true),
            Dunkelelfe("Lilithra", 700, "Gurthang-Schwert", 100, "Dolch", false)
        )
    )

    val gegner: MutableList<Gegner> = mutableListOf()
    gegner.addAll(
        mutableListOf(
            Endgegner("Icy", 1000, "Hammer", 100),
            Gehilfe("Stormy", 400, "Dolch", 100)
        )
    )

    val beutel = Beutel()
//    beutel.inhalt()

    gegner.filterIsInstance<Gehilfe>().first().stehlen(beutel)
//    gegner.filterIsInstance<Endgegner>().first().schneesturm(helden)
//    val druide = Druide("Alderwood",500,"Stab",100,false)
//    val zwerg = Zwerg("Gimli",600,"Axt",100,true)
//    val dunkelelfe = Dunkelelfe("Lilithra",700,"Gurthang-Schwert",100,"Dolch",false)
//    helden.filterIsInstance<Druide>().first().heilzauber(helden)
//    helden.filterIsInstance<Druide>().first().beutel(beutel)

}