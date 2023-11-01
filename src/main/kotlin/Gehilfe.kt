class Gehilfe(name: String,hp: Int,waffe: String,atk: Int): Schurke(name,hp,waffe,atk) {
    fun anschleichen() {

    }
    fun stehlen() {

    }

    override fun basicAtk(helden: MutableList<Held>) {
        super.basicAtk(helden)
    }

    override fun powerAtk(helden: MutableList<Held>) {
        super.powerAtk(helden)
    }
}