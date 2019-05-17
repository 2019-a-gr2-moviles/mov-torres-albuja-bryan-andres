package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividad_dos.*
import kotlinx.android.synthetic.main.content_main.*

class ActividadDos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dos)

        val nombre: String? = intent.getStringExtra("nombre")
        val edad: Int? = intent.getIntExtra("edad", 0)

        // println("Nombre $nombre")
        // println("Edad $edad")


        Log.i("nombre", "$nombre")
        Log.i("edad", "$edad")

        btn_actividad_uno.setOnClickListener { view ->
            irActividadUno()
        }
    }

    fun irActividadUno() {
        val intent = Intent(
        this, MainActivity::class.java
        )
        // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
