package com.example.damn_rca_examen_02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnRV = findViewById<Button>(R.id.Usuarios)
        val btnCredi = findViewById<Button>(R.id.Creditos)
        val btnSalir = findViewById<Button>(R.id.Salir)

        btnRV.setOnClickListener {
            val intentCalculadora = Intent(this,MainActivity::class.java)
            startActivity(intentCalculadora)
        }

        btnCredi.setOnClickListener {
            val intentCreditos = Intent(this, Creditos::class.java)
            startActivity((intentCreditos))
        }

        btnSalir.setOnClickListener {
            finishAndRemoveTask()
        }
    }
}