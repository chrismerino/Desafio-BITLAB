/*
 * Copyright (c) 2019.  Cristian Merino, All rights reserved.
 * https://linkedin.com/chrismerino
 */

package sv.edu.bitlab.desafio.cristian

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import sv.edu.bitlab.desafio.cristian.R
import kotlinx.android.synthetic.main.fragment_form_view.*
import java.lang.ClassCastException


class FormViewFragment : Fragment() {

    // Declarando elementos de UI
    var botonEnviar: Button? = null

    // TODO: Implementar el Adapter para el Spinner (Ocupar el Custom Layout! :D)



    var listener: Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_form_view, container, false)

        botonEnviar = view.findViewById(R.id.bntEnviar)

        botonEnviar?.setOnClickListener{ view ->


            // TODO: Manejar el Spinner desde el onCreateView


            if (etNombre.text.isEmpty()
                or (etCorreoElectronico.text.isEmpty())){
                Toast.makeText(view.context, "Necesita completar la informacion", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(view.context, "La informacion ha sido enviada!", Toast.LENGTH_SHORT).show()
                listener?.callMyFragment()
            }




        }

        return view

    }

    interface Listener{

        fun callMyFragment()

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try {
            listener = context as Listener
        } catch (e: ClassCastException){
            throw ClassCastException(context.toString() + "debes implementar la interface")
        }

    }

    companion object {

        fun newInstance() : FormViewFragment {
            val fragment = FormViewFragment()
            return fragment
        }
    }

}
