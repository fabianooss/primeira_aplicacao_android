package org.senac.primeiraaplicacao.org.senac.imc

import android.content.Context
import org.senac.primeiraaplicacao.R

class Imc (val peso: Double,
           val altura: Double,
           val genero: GeneroEnum) {

    fun calcularImc() : Double {
        return peso / (altura * altura)
    }

    /*
    Baixo peso muito grave = abaixo de 16 kg/m².
Baixo peso grave = entre 16 e 16,99 kg/m².
Baixo peso = entre 17 e 18,49 kg/m².
Peso normal = entre 18,50 e 24,99 kg/m².
Sobrepeso = entre 25 e 29,99 kg/m².
Obesidade grau I = entre 30 e 34,99 kg/m².
Obesidade grau II = entre 35 e 39,99 kg/m².
Obesidade grau III (obesidade mórbida) = maior que 40 kg/m².

     */
    fun classificacao() : Int {
        val imc = this.calcularImc()


        return when  {
            imc < 16 -> R.string.baixoPesoMuitoGrave
            imc < 17 ->  R.string.baixoPesoGrave
            imc < 18.50 -> R.string.baixoPeso
            imc < 25 ->  R.string.pesoNormal
            imc < 30 -> R.string.sobrepeso
            imc < 35 -> R.string.obesidadegrauI
            imc < 40 -> R.string.obesidadegrauII
            else -> R.string.obesidadegrauIII
        }
    }
    /*
    Homem: (Altura (em cm) - 100) x 0.90
    Mulher: (Altura (em cm) - 100) x 0.85

     */
    fun pesoIdeal() : Double {
        if (this.genero == GeneroEnum.Masculino) {
            return (altura * 100 - 100) * 0.9
        }
        return (altura * 100 - 100) * 0.85

    /*
        return when (this.genero) {
            GeneroEnum.Masculino -> (altura * 100 - 100) * 0.9
            else -> (altura * 100 - 100) * 0.85
        }
*/

    }


}

enum class GeneroEnum {
    Masculino, Feminino

}
