package com.example.practica3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.app.AlertDialog

class CalculadoraActivity : AppCompatActivity() {
    private lateinit var btnSumar: Button;
    private  lateinit var btnRestar: Button;
    private lateinit var btnMultiplicar: Button;
    private lateinit var btnDividir: Button;
    private lateinit var btnLimpiar: Button;
    private lateinit var btnAbandonar: Button

    private lateinit var txtNum1: EditText;
    private lateinit var txtNum2: EditText;
    private lateinit var lblResultado: TextView;
    private var Calculadora = Calculadora(0, 0);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        iniciarComponentes()

        btnSumar.setOnClickListener { btnSumar() }
        btnRestar.setOnClickListener { btnRestar() }
        btnMultiplicar.setOnClickListener { btnMultiplicar()}
        btnDividir.setOnClickListener { btnDividir() }
        btnLimpiar.setOnClickListener { btnLimpiar() }
        btnAbandonar.setOnClickListener { btnAbandonar() }

        }
    private fun iniciarComponentes() {
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnDividir = findViewById(R.id.btnDividir)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnAbandonar = findViewById(R.id.btnAbandonar)

        lblResultado = findViewById(R.id.lblResultado)
        Calculadora = Calculadora(0, 0)
    }

    private fun btnSumar() {
        val num1 = txtNum1.text.toString()
        val num2 = txtNum2.text.toString()

        if (num1.isEmpty() || num2.isEmpty()) {
            mostrarAlerta("Error", "Primero debes ingresar los números para hacer las operaciones")
        } else {
            val resultado = num1.toDouble() + num2.toDouble()
            lblResultado.text = resultado.toString()
        }
    }



    private fun btnRestar() {
        val num1 = txtNum1.text.toString()
        val num2 = txtNum2.text.toString()

        if (num1.isEmpty() || num2.isEmpty()) {
            mostrarAlerta("Error", "Primero debes ingresar los números para hacer las operaciones")
        } else {
            val resultado = num1.toDouble() - num2.toDouble()
            lblResultado.text = resultado.toString()
        }
    }

    private fun btnDividir() {
        val num1 = txtNum1.text.toString()
        val num2 = txtNum2.text.toString()

        if (num1.isEmpty() || num2.isEmpty()) {
            mostrarAlerta("Error", "Primero debes ingresar los números para hacer las operaciones")
        } else {
            val num2Value = num2.toDouble()
            if (num2Value != 0.0) {
                val resultado = num1.toDouble() / num2Value
                lblResultado.text = resultado.toString()
            } else {
                mostrarAlerta("Error", "No se puede dividir entre cero")
            }
        }
    }


    private fun btnMultiplicar() {
        val num1 = txtNum1.text.toString()
        val num2 = txtNum2.text.toString()

        if (num1.isEmpty() || num2.isEmpty()) {
            mostrarAlerta("Error", "Primero debes ingresar los números para hacer las operaciones")
        } else {
            val resultado = num1.toDouble() * num2.toDouble()
            lblResultado.text = resultado.toString()
        }
    }

    private fun btnLimpiar() {
        txtNum1.setText("")
        txtNum2.setText("")
        lblResultado.setText("")
    }

    private fun btnAbandonar() {
        val confirmar = android.app.AlertDialog.Builder(this)
        confirmar.setTitle("Calculadora")
        confirmar.setMessage("¿Deseas regresar?")
        confirmar.setPositiveButton("Confirmar") { _, _ -> finish() }
        confirmar.setNegativeButton("Cancelar", null)
        confirmar.show()
    }

    private fun mostrarAlerta(titulo: String, mensaje: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(titulo)
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar", null)
        val dialog = builder.create()
        dialog.show()
    }


}



