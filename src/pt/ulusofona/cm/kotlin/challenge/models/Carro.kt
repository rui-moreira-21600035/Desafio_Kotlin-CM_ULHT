package pt.ulusofona.cm.kotlin.challenge.models

class Carro(identificador: String) : Veiculo(identificador){
    override var identificador: String = String()
        get() = field
        set(value) {field = value}

    var motor: Motor = Motor()
        get() = field
        set(value) {field = value}

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | " + identificador + " | " + dataDeAquisicao + " | " +
                posicao.toString()
    }
}
