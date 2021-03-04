package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.*
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.models.*
import java.text.SimpleDateFormat

class Carro(identificador: String, var motor: Motor) : Veiculo(identificador), Ligavel {
    override fun requerCarta(): Boolean {
        return true
    }

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | " + identificador + " | " + SimpleDateFormat("dd-MM-yyyy").format(dataDeAquisicao) + " | " +
                posicao.toString()
    }

    @Throws(AlterarPosicaoException::class)
    override fun moverPara(x: Int, y: Int) {
        if(!motor.estaLigado()){
            motor.ligar()
        }
        posicao.alterarPosicaoPara(x, y)
        motor.desligar()
    }

    override fun ligar() {
        motor.ligar()
    }

    override fun desligar() {
        motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }
}
