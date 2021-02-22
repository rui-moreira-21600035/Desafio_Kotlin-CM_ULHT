package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.*
import pt.ulusofona.cm.kotlin.challenge.models.Date

class Pessoa() {

    private var nome: String = String()
        get() = field
        set(value) {field = value}

    private var veiculos = mutableListOf<Veiculo>()
        get() = field
        set(value) {field = value}

    private var dataDeNascimento: Date = Date()
        get() = field
        set(value) {field = value}

    private var carta: Carta = Carta()
        get() = field
        set(value) {field = value}

    private var posicao: Posicao = Posicao()

    constructor(nome: String, dataDeNascimento: Date) : this(){
        this.nome = nome
        this.dataDeNascimento = dataDeNascimento
    }

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
}


