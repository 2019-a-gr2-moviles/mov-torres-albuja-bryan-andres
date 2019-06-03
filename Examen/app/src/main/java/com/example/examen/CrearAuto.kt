package com.example.examen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crear_auto.*
import kotlinx.android.synthetic.main.activity_detalle_conductor.*

class CrearAuto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_auto)

        val idConductor = intent.getIntExtra("conductorID", 0)

        btn_guardar_auto.setOnClickListener { view ->
            crearAuto(idConductor)

            Toast.makeText(view.context,"${Usuario.nombre}, el auto se ha creado satisfactoriamente",
                Toast.LENGTH_SHORT).show()
        }
    }

    fun crearAuto(idConductor: Int) {
        val chasisAuto = txt_chasis.text.toString().toInt()
        val nombreMarcaAuto = txt_nombre_marca.text.toString()
        val colorUnoAuto = txt_color_uno.text.toString()
        val colorDosAuto = txt_color_dos.text.toString()
        val nombreModeloAuto = txt_nombre_modelo.text.toString()
        val anioAuto = txt_anio.text.toString().toInt()

        Auto.listaAutos.add(
            Auto(
                chasisAuto,
                nombreMarcaAuto,
                colorUnoAuto,
                colorDosAuto,
                nombreModeloAuto,
                anioAuto,
                Conductor.listaConductores[idConductor]
            )
        )
    }
}
