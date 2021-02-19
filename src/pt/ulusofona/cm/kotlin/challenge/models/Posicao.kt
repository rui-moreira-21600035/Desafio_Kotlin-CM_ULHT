package pt.ulusofona.cm.kotlin.challenge.models

class Posicao(){
    var x: Int = 0
    var y: Int = 0

    constructor(x: Int, y: Int) : this() {
        this.x = x
        this.y = y
    }

    fun alterarPosicaoPara(x: Int, y: Int){
        this.x = x
        this.y = y
    }

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | x:" + this.x + " | y:" + this.y
    }
}
