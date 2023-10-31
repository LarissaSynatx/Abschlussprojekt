class Zwerg(name: String, hp: Int, waffe: String, atk: Int, schild: Boolean):Held(name,hp,waffe,atk,schild) {
    fun jumpAndHit() {

    }
    fun spinAndHit() {

    }
   fun schildBlock(schurke: Schurke) {
       println("$name hebt sein Schild und macht sich für den nächsten Angriff bereit!")
       schild = true
    }
}