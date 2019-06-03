package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_entrar.setOnClickListener { view ->
            irAMenu()

            Toast.makeText(view.context,"Bienvenido ${Usuario.nombre}",
                Toast.LENGTH_SHORT).show()
        }
    }

    fun irAMenu() {
        Usuario.nombre = txt_nombre_usuario.text.toString()
        val intentMenuConductores = Intent(
            this,
            Menu::class.java)

        startActivity(intentMenuConductores)
    }
}
