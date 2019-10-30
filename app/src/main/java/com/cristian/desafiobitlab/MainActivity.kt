package com.cristian.desafiobitlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity(), FormViewFragment.NombreListener {

    var mostrarNombre: TextView? = null
    var buttonEnviar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // mostrarNombre = findViewById(R.id.)

        val fragmentManager = supportFragmentManager

        // Mostrando el primer fragment
        val fragmentTransaction = fragmentManager.beginTransaction()
        val firstFragment = FormViewFragment()

        fragmentTransaction.add(R.id.root_layout, firstFragment)
        fragmentTransaction.commit()

        buttonEnviar = findViewById(R.id.bntEnviar)
        buttonEnviar?.setOnClickListener{

            val fragmentTransaction = fragmentManager.beginTransaction()

            val newFragment = SuccessViewFragment()
            fragmentTransaction.replace(R.id.root_layout, newFragment)

            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }

    }

    override fun obtenerNombre(nombre: String) {
        super.obtenerNombre(nombre)
        mostrarNombre?.text = nombre
    }
}
