package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detalle_auto.*

class DetalleAuto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_auto)

        val idConductor = intent.getIntExtra("conductorID", 0)
        val idAuto = intent.getIntExtra("autoID", 0)

        mostrarDetalle(idConductor, idAuto)

        btn_eliminar_auto.setOnClickListener { view ->
            Toast.makeText(view.context,"${Usuario.nombre} ha eliminado el auto con modelo ${Auto.autoPorConductor(Conductor.listaConductores[idConductor])[idAuto].nombreModelo}",
                Toast.LENGTH_SHORT).show()

            eliminarAuto(idConductor, idAuto)
        }

        btn_actualizar_auto.setOnClickListener {view ->
            actualizarAuto(idConductor, idAuto)

            Toast.makeText(view.context,"${Usuario.nombre} ha actualizado el auto con modelo ${Auto.autoPorConductor(Conductor.listaConductores[idConductor])[idAuto].nombreModelo}",
                Toast.LENGTH_SHORT).show()
        }
    }

    fun mostrarDetalle(idConductor: Int, idAuto: Int) {
        val autoDetalle = Auto.autoPorConductor(Conductor.listaConductores[idConductor])[idAuto]

        txt_chasis_detalle.setText("" + autoDetalle.chasis)
        txt_nombre_marca_detalle.setText(autoDetalle.nombreMarca)
        txt_color_uno_detalle.setText(autoDetalle.colorUno)
        txt_color_dos_detalle.setText(autoDetalle.colorDos)
        txt_nombre_modelo_detalle.setText(autoDetalle.nombreModelo)
        txt_anio_detalle.setText("" + autoDetalle.anio)
    }

    fun eliminarAuto(idConductor: Int, idAuto: Int) {
        Auto.listaAutos.remove(
            Auto.autoPorConductor(Conductor.listaConductores[idConductor])[idAuto]
        )

        redirigirADetalleConductor(idConductor)
    }

    fun actualizarAuto(idConductor: Int, idAuto: Int) {
        Auto.autoPorConductor(Conductor.listaConductores[idConductor])[idAuto].editarAuto(
            txt_chasis_detalle.text.toString().toInt(),
            txt_nombre_marca_detalle.text.toString(),
            txt_color_uno_detalle.text.toString(),
            txt_color_dos_detalle.text.toString(),
            txt_nombre_modelo_detalle.text.toString(),
            txt_anio_detalle.text.toString().toInt()
        )
    }

    fun redirigirADetalleConductor(idConductor: Int) {
        val intentDetalleConductor = Intent(
            this,
            DetalleConductor::class.java
        )

        startActivity(intentDetalleConductor)
        finish()
    }
}
