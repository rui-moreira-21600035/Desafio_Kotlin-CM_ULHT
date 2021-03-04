package pt.ulusofona.cm.kotlin.challenge.interfaces

import pt.ulusofona.cm.kotlin.challenge.exceptions.*

interface Ligavel {
    @Throws(VeiculoLigadoException::class)
    fun ligar()

    @Throws(VeiculoDesligadoException::class)
    fun desligar()

    fun estaLigado(): Boolean

}
