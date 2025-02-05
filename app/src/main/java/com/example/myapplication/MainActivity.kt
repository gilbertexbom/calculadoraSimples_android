package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Define objetos de interface gráfica para manipulação via código
        val num1 = findViewById<EditText>(R.id.txtNum1)
        val num2 = findViewById<EditText>(R.id.txtNum2)
        val soma = findViewById<Button>(R.id.btnCalcular)
        val total = findViewById<TextView>(R.id.txtTotal)
        val limpar = findViewById<Button>(R.id.btnLimpar)
        val rbtSoma = findViewById<RadioButton>(R.id.rbtSoma)
        val rbtSub = findViewById<RadioButton>(R.id.rbtSubtracao)


        limpar.setOnClickListener {
            //limpa os campos de texto
            num1.text.clear()
            num2.text.clear()
            total.text = ""

            //Atribui o foco ao primeiro campo
            num1.requestFocus()

            //Marcar soma como padrão
            rbtSoma.isChecked = true
        }

        soma.setOnClickListener{
            //Recebe os dados da interface gráfica
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.00
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.00
            var resultado = 0.00

            if (rbtSoma.isChecked) {
                //Efetua a soma
                resultado = n1 + n2
            } else {
                //Efetua a subtração
                resultado = n1 - n2
            }

            //Retorna o resultado na interface gráfica.
            total.text = "$n1 + $n2 = $resultado"
        }
    }
}