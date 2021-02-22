package pt.ulusofona.cm.kotlin.challenge.models

import java.util.Date

class Date() : Date(){
    var dia: Int = 0
        get() = field
        set(value) {field = value}

    var mes: Int = 0
        get() = field
        set(value) {field = value}

    var ano: Int = 0
        get() = field
        set(value) {field = value}

    constructor(dia:Int, mes:Int, ano:Int) : this(){
        this.dia = dia
        this.mes = mes
        this.ano = ano
    }

    override fun toString(): String{
        var diaStr: String = dia.toString()
        var mesStr: String = mes.toString()
        if (diaStr.length.equals(1)) {
            diaStr = "0" + dia.toString()
        }
        if (mesStr.length.equals(1)) {
            mesStr = "0" + mes.toString()
        }

        return diaStr + "-" + mesStr + "-" + ano.toString()
    }

}
