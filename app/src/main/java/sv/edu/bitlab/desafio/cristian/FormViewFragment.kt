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
import android.widget.*
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_form_view.*
import java.lang.ClassCastException
import java.lang.Exception


class FormViewFragment : Fragment() {

    // Declarando elementos de UI
    var botonEnviar: Button? = null
    var textViewColeccion: TextView? = null

    var mStorageRef: StorageReference? = null
    var fireStoreDatabase: FirebaseFirestore? = null
    var myDB: DocumentReference? = null



    // TODO: Implementar el Adapter para el Spinner (Ocupar el Custom Layout! :D)



    var listener: Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_form_view, container, false)

        // TODO: Manejar el Spinner desde el onCreateView

        botonEnviar = view.findViewById(R.id.bntEnviar)
        textViewColeccion = view.findViewById(R.id.textView_ver_coleccion)

        val editTextNombre = view?.findViewById<EditText>(R.id.etNombre)
        val editTextCorreo = view?.findViewById<EditText>(R.id.etCorreoElectronico)
        val editTextNumero = view?.findViewById<EditText>(R.id.etNumeroTelefonico)

        val itemNombre = "TextoUno"
        val itemCorreo = "TextoDos"
        val itemNumero = "TextoTres"

        botonEnviar?.setOnClickListener{ view -> myFireStorePrueba()

            //mStorageRef = FirebaseStorage.getInstance().getReference()
            //myDB = FirebaseFirestore.getInstance().document("accounts/")








/*            if (etNombre.text.isEmpty()
                or (etCorreoElectronico.text.isEmpty())){
                Toast.makeText(view.context, "Necesita completar la informacion", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(view.context, "La informacion ha sido enviada!", Toast.LENGTH_SHORT).show()
                listener?.callCollectionFragment()
            }*/

        }

        // SetOnClickListener del TextView Collecion

        textViewColeccion?.setOnClickListener{
            listener?.callCollectionFragment()
        }

        return view

    }

    fun myFireStorePrueba() {



        val itemNombre = "TextoUno"
            //editTextNombre?.text.toString()
        val itemCorreo = "TextoDos"
            //editTextCorreo?.text.toString()
        val itemNumero = "TextoTres"
            //editTextNumero?.text.toString()

        if (!itemNombre.isEmpty() && !itemCorreo.isEmpty() && !itemNumero.isEmpty()){
            try {
                val items = HashMap<String, Any>()
                items.put("TextoUno", itemNombre)
                items.put("TextoDos", itemCorreo)
                items.put("TextoTres", itemNumero)
                myDB?.collection("accounts/")?.document("accounts")?.set(items)?.addOnSuccessListener {
                    void: Void -> Toast.makeText(view?.context, "Datos enviados a FireStore", Toast.LENGTH_SHORT).show()
                }?.addOnFailureListener {
                    exception: java.lang.Exception -> Toast.makeText(view?.context, exception.toString(), Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception){
                Toast.makeText(view?.context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(view?.context, "Completar los campos", Toast.LENGTH_SHORT).show()
        }

    }


    interface Listener{

        fun callCollectionFragment()

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
