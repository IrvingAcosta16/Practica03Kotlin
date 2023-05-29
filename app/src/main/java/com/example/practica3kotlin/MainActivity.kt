package com.example.practica3kotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent


class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var btnAbandonar: Button
    private lateinit var txtUsuario: EditText
    private lateinit var txtContraseña: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponentes()
        btnLogin.setOnClickListener { Login() }
        btnAbandonar.setOnClickListener { Abandonar() }
}

    private fun iniciarComponentes(){
    btnLogin = findViewById(R.id.btnLogin)
    btnAbandonar = findViewById(R.id.btnAbandonar)
    txtContraseña = findViewById(R.id.txtContraseña)
    txtUsuario = findViewById(R.id.txtUsuario)
    }

    private fun Login() {
        val strUsuario: String = resources.getString(R.string.usuario)
        val strContra: String = resources.getString(R.string.contraseña)

        if (txtUsuario.text.toString() == strUsuario && txtContraseña.text.toString() == strContra) {
            val intent = Intent(this@MainActivity, CalculadoraActivity::class.java)
            intent.putExtra("Usuario", strUsuario)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Usuario o contraseña invalida", Toast.LENGTH_LONG).show()
        }
    }
    private fun Abandonar() {
        val confirmar = android.app.AlertDialog.Builder(this)
        confirmar.setTitle("Calculadora")
        confirmar.setMessage("¿Deseas salir?")
        confirmar.setPositiveButton("Confirmar") { _, _ -> finish() }
        confirmar.setNegativeButton("Cancelar", null)
        confirmar.show()
    }
}