package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.exceptions.*

class Motor(var cavalos: Int, var cilindrada: Int) : Ligavel {
    var ligado: Boolean = false

    override fun ligar() {
        if (this.ligado) {
            throw VeiculoLigadoException("O Veiculo já se encontra ligado")
        } else {
            this.ligado= true
        }
    }

    override fun desligar() {
        if (!this.ligado) {
            throw VeiculoDesligadoException("O Veiculo já se encontra desligado")
        } else {
            this.ligado = false
        }
    }

    override fun estaLigado(): Boolean {
        return this.ligado
    }

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | " + this.cavalos + " | " + this.cilindrada
    }
}
