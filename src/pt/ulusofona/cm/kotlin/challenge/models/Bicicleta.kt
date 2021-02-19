package pt.ulusofona.cm.kotlin.challenge.models

class Bicicleta(identificador: String) : Veiculo(identificador){

    override  var identificador: String = String()
        get() = field
        set(value) {field = value}

    override fun toString(): String{
        return javaClass.kotlin.toString() + " | " + identificador + " | " + dataDeAquisicao + " | " +
                posicao.toString()
    }
}
