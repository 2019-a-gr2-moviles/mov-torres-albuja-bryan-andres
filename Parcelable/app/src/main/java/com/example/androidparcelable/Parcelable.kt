package com.example.androidparcelable

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log

import kotlinx.android.synthetic.main.activity_parcelable.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val andres: Usuario? = this.intent.getParcelableExtra<Usuario>("usuario")

        Log.i("parcelable", "Nombre ${andres?.nombre}")
    }

    fun regresarAMenu() {
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )

        startActivity(intentExplicito)
    }

}
