package org.senac.primeiraaplicacao.org.senac.imc

class Imc (val peso: Double,
           val altura: Double,
           val genero: GeneroEnum) {

    fun calcularImc() : Double {
        return peso / (altura * altura)
    }


}

enum class GeneroEnum {
    Masculino, Feminino

}
