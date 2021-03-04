package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.*
import java.text.SimpleDateFormat

class Bicicleta(identificador: String) : Veiculo(identificador){
    override fun requerCarta(): Boolean {
        return false
    }

    override fun toString(): String{
        return javaClass.kotlin.toString() + " | " + identificador + " | " + SimpleDateFormat("dd-MM-yyyy").format(dataDeAquisicao) + " | " +
                posicao.toString()
    }

    @Throws(AlterarPosicaoException::class)
    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }
}
