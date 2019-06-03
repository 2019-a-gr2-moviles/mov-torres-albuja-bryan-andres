package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_gestion_conductores.*

class GestionConductores : AppCompatActivity() {

    private val listaNombresConductores = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_conductores)

        mostrarListaCoductores()
    }

    fun mostrarListaCoductores() {
        listaNombresConductores.clear()

        Conductor.listaConductores.forEach {
            listaNombresConductores.add(it.nombres)
        }

        actualizarListaConductores()
    }

    fun actualizarListaConductores() {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_expandable_list_item_1,
            listaNombresConductores
        )

        lv_lista_conductores.adapter = adapter
        lv_lista_conductores.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            irDetalleConductor(position)
        }
    }

    fun irDetalleConductor(posicion: Int) {
        val intentDetalleConductor = Intent(
            this,
            DetalleConductor::class.java
        )

        intentDetalleConductor.putExtra("conductorID", posicion)

        startActivity(intentDetalleConductor)
    }
}
