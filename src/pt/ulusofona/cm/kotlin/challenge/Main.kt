package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.*
import pt.ulusofona.cm.kotlin.challenge.models.Date

fun main() {
    // aqui escreves o código do programa
    var pessoa1 = Pessoa("Rui", Date(10, 2, 1992))

    println(pessoa1.toString())
    //pessoa1.pesquisarVeiculo("ABC") // Lança exception
}
