package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.*

data class Posicao(var x: Int, var y: Int){

    fun alterarPosicaoPara(x: Int, y: Int) {
        if (this.x == x && this.y == y) {
            throw AlterarPosicaoException("O Veiculo já se encontra nesta posição")
        } else {
            this.x = x
            this.y = y
        }
    }

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | x:" + this.x + " | y:" + this.y
    }
    init {
        this.x = x
        this.y = y
    }
}
