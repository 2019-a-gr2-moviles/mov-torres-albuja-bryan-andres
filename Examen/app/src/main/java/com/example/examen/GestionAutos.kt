package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_gestion_autos.*

class GestionAutos : AppCompatActivity() {

    private val listaAutos = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_autos)

        val idConductor = intent.getIntExtra("conductorID", -1)

        mostrarListaAutos(idConductor)
    }

    fun mostrarListaAutos(idConductor: Int) {
        listaAutos.clear()

        Auto.autoPorConductor(Conductor.listaConductores[idConductor]).forEach {
            listaAutos.add(it.nombreModelo)
        }

        actualizarListaAutos(idConductor)
    }

    fun actualizarListaAutos(idConductor: Int) {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_expandable_list_item_1,
            listaAutos
        )

        lv_lista_autos.adapter = adapter

        lv_lista_autos.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            irDetalleAuto(idConductor, position)
        }
    }

    fun irDetalleAuto(idConductor: Int, posicion: Int) {
        val intentDetalleAuto = Intent(
            this,
            DetalleAuto::class.java
        )

        intentDetalleAuto.putExtra("autoID", posicion)
        intentDetalleAuto.putExtra("conductorID", idConductor)

        startActivity(intentDetalleAuto)
        finish()
    }
}
