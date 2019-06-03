package com.example.examen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crear_conductor.*

class CrearConductor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_conductor)

        btn_guardar_conductor.setOnClickListener { view ->
            crearConductor()

            Toast.makeText(view.context,"${Usuario.nombre}, el conductor se ha creado satisfactoriamente",
                Toast.LENGTH_SHORT).show()
        }
    }

    fun crearConductor() {
        val nombresConductor = txt_nombres.text.toString()
        val apellidosConductor = txt_apellidos.text.toString()
        val fechaNacimientoConductor = txt_fecha_nacimiento.text.toString()
        val numeroAutosConductor = txt_numero_autos.text.toString().toInt()
        var licenciaValidaConductor = switch_licencia.isChecked

        Conductor.listaConductores.add(Conductor(
                nombresConductor,
                apellidosConductor,
                fechaNacimientoConductor,
                numeroAutosConductor,
                licenciaValidaConductor
            )
        )
    }
}