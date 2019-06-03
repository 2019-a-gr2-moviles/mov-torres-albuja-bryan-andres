package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detalle_conductor.*

class DetalleConductor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_conductor)

        val idConductor = intent.getIntExtra("conductorID", 0)

        mostrarDetalle(idConductor)

        btn_eliminar_conductor.setOnClickListener { view ->
            Toast.makeText(view.context,"${Usuario.nombre} a eliminado al conductor ${Conductor.listaConductores[idConductor].nombres}",Toast.LENGTH_SHORT).show()

            eliminarConductor(idConductor)
        }

        btn_actualizar_conductor.setOnClickListener { view ->
            actualizarConductor(idConductor)

            Toast.makeText(view.context,"${Usuario.nombre} a actualizado al conductor ${Conductor.listaConductores[idConductor].nombres}",Toast.LENGTH_SHORT).show()
        }

        btn_crear_auto.setOnClickListener {
             irACrearAuto(idConductor)
        }

        btn_gestionar_autos.setOnClickListener {
            irAGestionAutos(idConductor)
        }
    }

    fun mostrarDetalle(idConductor: Int) {
        val conductorDetalle = Conductor.listaConductores[idConductor]

        txt_nombres_detalle.setText(conductorDetalle.nombres)
        txt_apellidos_detalle.setText(conductorDetalle.apellidos)
        txt_fecha_nacimiento_detalle.setText(conductorDetalle.fechaNacimiento)
        txt_numero_autos_detalle.setText("" + conductorDetalle.numeroAutos)
        switch_licencia_valida_detalle.isChecked = conductorDetalle.licenciaValida
    }

    fun eliminarConductor(idConductor: Int) {
        Conductor.listaConductores.removeAt(idConductor)

        redirigirAGestionConductores()
    }

    fun actualizarConductor(idConductor: Int) {
        Conductor.listaConductores[idConductor].editarConductor(
            txt_nombres_detalle.text.toString(),
            txt_apellidos_detalle.text.toString(),
            txt_fecha_nacimiento_detalle.text.toString(),
            txt_numero_autos_detalle.text.toString().toInt(),
            switch_licencia_valida_detalle.isChecked
        )
    }

    fun irACrearAuto(idConductor: Int) {
        val intentCrearAuto = Intent(
            this,
            CrearAuto::class.java
        )

        intentCrearAuto.putExtra("conductorID", idConductor)
        startActivity(intentCrearAuto)
        finish()
    }

    fun irAGestionAutos(idConductor: Int) {
        val intentGestionAutos = Intent(
            this,
            GestionAutos::class.java
        )

        intentGestionAutos.putExtra("conductorID", idConductor)
        startActivity(intentGestionAutos)
        finish()
    }

    fun redirigirAGestionConductores() {
        val intentGestionConductores = Intent(
            this,
            GestionConductores::class.java
        )

        startActivity(intentGestionConductores)
        finish()
    }
}
