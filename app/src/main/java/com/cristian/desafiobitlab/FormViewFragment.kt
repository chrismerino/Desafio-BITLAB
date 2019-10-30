package com.cristian.desafiobitlab

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.ClassCastException


class FormViewFragment : Fragment() {

    var boton: Button? = null
    var listener: NombreListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_form_view, container, false)


        boton = view.findViewById(R.id.bntEnviar)
        boton?.setOnClickListener{
            Toast.makeText(view.context, "Hey", Toast.LENGTH_SHORT).show()


//            val nombreActual = nombreFromEditText?.text.toString()
//            listener?.obtenerNombre(nombreActual)
        }

        return view

    }

    interface NombreListener{

        fun obtenerNombre(nombre: String){

        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try {
            listener = context as NombreListener
        } catch (e: ClassCastException){
            throw ClassCastException(context.toString() + "debes implementar la interface")
        }

    }

}
