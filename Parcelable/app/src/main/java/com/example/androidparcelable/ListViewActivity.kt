package com.example.androidparcelable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listaNombres = arrayListOf<String>()
        listaNombres.add("Alexander")
        listaNombres.add("Andres")
        listaNombres.add("Adrian")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNombres)

        lv_ejemplo.adapter = adapter

        lv_ejemplo.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.i("list-viex", "Id $id")
            Snackbar.make(view, "Has seleccionado el elemento $position", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
