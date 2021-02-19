package pt.ulusofona.cm.kotlin.challenge.models

class Motor() {
    private var cavalos: Int = 0
        get() = field
        set(value) {
            field = value
        }

    private var cilindrada: Int = 0
        get() = field
        set(value) {
            field = value
        }

    private var ligado: Boolean = false
        get() = field
        set(value) {
            field = value
        }

    constructor(cavalos: Int, cilindrada: Int) : this()

    override fun toString(): String{
        return javaClass.simpleName.toString() + " | " + this.cavalos + " | " + this.cilindrada
    }
}
