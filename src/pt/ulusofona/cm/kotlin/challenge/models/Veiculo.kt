package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.models.*

open class Veiculo(identificador: String) {
    open var identificador: String = String()
        get() = field
        set(value) {field = value}

    open var posicao: Posicao = Posicao()
        get() = field
        set(value) {field = value}

    open var dataDeAquisicao: Date = Date()
        get() = field
        set(value) {field = value}

    open fun requerCarta(): Boolean {
        return false
    }

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | " + identificador + " | " + dataDeAquisicao + " | " +
                posicao.toString()
    }
}
