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

    var editTextNombre: EditText? = null
    var editTextCorreoElectronico: EditText? = null
    var editTextNumeroTelefonico: EditText? = null
    var spinnerCuentanos: Spinner? = null
    var imageAccount: String? = null


    var botonEnviar: Button? = null
    var textViewColeccion: TextView? = null

    var mStorageRef: StorageReference? = null
    var fireStoreDatabase: FirebaseFirestore? = null

    var myFirestoreDB = FirebaseFirestore.getInstance()

    var accountName: String? = null
    var accountEmail: String? = null
    var accountPhone: String? = null
    var accountFoundOutBy: String? = null
    var accountImage: String? = null



    // TODO: Implementar el Adapter para el Spinner (Ocupar el Custom Layout! :D)

    var listener: Listener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_form_view, container, false)


        botonEnviar = view.findViewById(R.id.bntEnviar)

        botonEnviar?.setOnClickListener{
            view: View? ->
        }


        // TODO: Manejar el Spinner desde el onCreateView

        textViewColeccion = view.findViewById(R.id.textView_ver_coleccion)

        editTextNombre = view?.findViewById(R.id.etNombre)
        // accountName = editTextNombre?.text.toString().trim()
        accountName = "Chris"

        editTextCorreoElectronico = view?.findViewById(R.id.etCorreoElectronico)
        // accountEmail = editTextCorreoElectronico?.text.toString().trim()
        accountEmail = "cris.merino@live.com"

        editTextNumeroTelefonico = view?.findViewById(R.id.etNumeroTelefonico)
        // accountPhone = editTextNumeroTelefonico?.text.toString(). trim()
        accountPhone = "12345678"

        spinnerCuentanos = view?.findViewById(R.id.spinner_Informacion)
        accountFoundOutBy = "Soy un spinner quemado"

        // imageAccount
        accountImage = "Esto deberia ser una imagen..."

        var dataclass = Account(accountName, accountEmail, accountPhone, accountFoundOutBy, accountImage)




        botonEnviar?.setOnClickListener{ view ->
            datosAFirestore(dataclass)


            /*if (etNombre.text.isEmpty()
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

    fun datosAFirestore(account: Account){
        myFirestoreDB.collection("accounts")
            .add(account)
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
