package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.*
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

data class Pessoa(val nome: String, private val dataDeNascimento: Date) : Movimentavel {
    var veiculos = mutableListOf<Veiculo>()
    var carta: Carta? = null
    var posicao: Posicao

    fun comprarVeiculo(veiculo: Veiculo){
        this.veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        for (veiculo in veiculos) {
            if (veiculo.identificador.equals(identificador)) {
                return veiculo
            }
        }
        return throw VeiculoNaoEncontradoException("Veiculo não encontrado")

    }

    fun venderVeiculo(identificador: String, comprador: Pessoa){
        var veiculoAVender: Veiculo
        for (veiculo in veiculos) {
            if (veiculo.identificador.equals(identificador)) {
                veiculoAVender = veiculo
                this.veiculos.remove(veiculo)
                comprador.veiculos.add(veiculoAVender)
            }
        }
        return throw VeiculoNaoEncontradoException("Veiculo não encontrado")
    }

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | " + nome + " | " + dataDeNascimento + " | " +
                posicao.toString()
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    init {
        posicao = Posicao(0, 0)
        veiculos = ArrayList()
    }
}


