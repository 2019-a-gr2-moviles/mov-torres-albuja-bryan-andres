package com.example.androidparcelable

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        btn_adapter.setOnClickListener{
            irAListView()
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun irAParcelable() {
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )

        val andres = Usuario("Andrés", 23, Date(), 250.00)

        val buck = Mascota("Buck", andres)

        intentExplicito.putExtra("usuario", andres)
        intentExplicito.putExtra("mascota", buck)

        startActivity(intentExplicito)
    }

    fun irAListView() {
        val intentExplicito = Intent(
            this,
            ListViewActivity::class.java
        )

        startActivity(intentExplicito)
    }
}
