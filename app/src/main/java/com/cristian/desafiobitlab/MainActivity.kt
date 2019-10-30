package com.cristian.desafiobitlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity(), FormViewFragment.NombreListener {

    var mostrarNombre: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // mostrarNombre = findViewById(R.id.)

    }

    override fun obtenerNombre(nombre: String) {
        super.obtenerNombre(nombre)
        mostrarNombre?.text = nombre
    }
}
