package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.*
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
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

    @Throws(AlterarPosicaoException::class, PessoaSemCartaException::class)
    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        for (veiculo in veiculos) {
            if (veiculo.identificador.equals(identificador) ) {
                if (veiculo.requerCarta() && !temCarta()) {
                    throw PessoaSemCartaException(nome + " não tem carta para conduzir o veículo indicado")
                }
                veiculo.moverPara(x, y)
                break
            }
        }
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    @Throws(MenorDeIdadeException::class)
    fun tirarCarta() {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val formatter = SimpleDateFormat("dd/MM/yyyy")

        val dateString =formatter.format(dataDeNascimento)

        val localDate = LocalDate.parse(dateString, dateTimeFormatter)



        val menorDeIdade = ChronoUnit.YEARS.between(localDate, LocalDate.now())
        if (menorDeIdade < 18) {
            throw MenorDeIdadeException("Não tem idade suficiente para tirar a carta")
        } else {
            carta = Carta()
        }
    }

    fun temCarta(): Boolean {
        return if (carta == null) false else true
    }

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | " + nome + " | " + SimpleDateFormat("dd-MM-yyyy").format(dataDeNascimento) + " | " +
                posicao.toString()
    }

    init {
        posicao = Posicao(0, 0)
        veiculos = mutableListOf<Veiculo>()
    }
}


