package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btn_gestion_conductores.setOnClickListener { view ->
            irGestionConductores()
        }

        btn_crear_conductor.setOnClickListener { view ->
            irCrearConductor()
        }
    }

    fun irGestionConductores() {
        val intentGestionConductores = Intent(
            this,
            GestionConductores:: class.java
        )

        startActivity(intentGestionConductores)
    }

    fun irCrearConductor() {
        val intentCrearConductor = Intent(
            this,
            CrearConductor::class.java
        )

        startActivity(intentCrearConductor)
    }
}
