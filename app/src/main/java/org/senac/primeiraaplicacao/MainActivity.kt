package org.senac.primeiraaplicacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.senac.primeiraaplicacao.org.senac.imc.GeneroEnum
import org.senac.primeiraaplicacao.org.senac.imc.Imc

class MainActivity : AppCompatActivity() {

    private lateinit var peso : EditText
    private lateinit var altura: EditText
    private lateinit var generoGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        peso = findViewById<EditText>(R.id.et_peso)
        altura = findViewById<EditText>(R.id.et_altura)
        generoGroup = findViewById<RadioGroup>(R.id.rg_genero)
        val btn = findViewById<Button>(R.id.bt_calcular)
        btn.setOnClickListener {
            if (validate()) {

                val genero =
                    if (generoGroup.checkedRadioButtonId == R.id.rb_masculino)
                        GeneroEnum.Masculino
                    else
                        GeneroEnum.Feminino


                val imc = Imc(
                    peso.text.toString().toDouble(),
                    altura.text.toString().toDouble(),
                    genero
                )

                val imcFormatado =
                    String.format("%.2f", imc.calcularImc())

                Toast.makeText(
                    this,
                    "Seu IMC é ${imcFormatado} kg/m",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun validate() : Boolean {
        var result = true
        if (peso.getText().trim().length == 0) {
            peso.setError("Campo é obrigatório")
            result = false
        }
        if (altura.text.trim().length == 0) {
            altura.setError("Campo é obrigatório")
            result = false
        }
        return result
    }
}
