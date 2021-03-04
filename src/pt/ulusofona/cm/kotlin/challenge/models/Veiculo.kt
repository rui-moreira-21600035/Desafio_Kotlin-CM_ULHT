package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import pt.ulusofona.cm.kotlin.challenge.models.*
import java.util.*

open abstract class Veiculo(var identificador: String) : Movimentavel {
    var posicao: Posicao
    var dataDeAquisicao: Date

    init {
        this.posicao = Posicao(0,0)
        this.dataDeAquisicao = Date()
    }

    abstract fun requerCarta(): Boolean

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | " + identificador + " | " + dataDeAquisicao + " | " +
                posicao.toString()
    }
}
