/*
 * Copyright (c) 2019.  Cristian Merino, All rights reserved.
 * https://linkedin.com/chrismerino
 */

package sv.edu.bitlab.desafio.cristian

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.lang.ClassCastException


class FormViewFragment : Fragment() {

    var mStorageRef: StorageReference = FirebaseStorage.getInstance().reference
    var myFirestoreDB = FirebaseFirestore.getInstance()

    // Declarando elementos de UI

    var accountName: EditText? = null
    var accountEmail: EditText? = null
    var accountPhone: EditText? = null
    var accountFoundBy: Spinner? = null
    var accountImage: StorageReference = mStorageRef!!.child("accounts-image/avatar.jpg")

    var textViewColeccion: TextView? = null

    // Declarando Boton Enviar

    var botonEnviar: Button? = null
    var listener: Listener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_form_view, container, false)

        // Inicializar componentes de UI

        accountName = view?.findViewById(R.id.etNombre)
        accountEmail = view?.findViewById(R.id.etCorreoElectronico)
        accountPhone = view?.findViewById(R.id.etNumeroTelefonico)
        accountFoundBy = view?.findViewById(R.id.spinner_Informacion)

        botonEnviar = view.findViewById(R.id.bntEnviar)
        textViewColeccion = view.findViewById(R.id.textView_ver_coleccion)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        botonEnviar?.setOnClickListener {


            if (accountName?.text!!.isEmpty() or accountEmail?.text!!.isEmpty()){
                Toast.makeText(view.context, "Nombre y correo son obligatorios.", Toast.LENGTH_SHORT).show()
            } else {

                var imageURI : Uri = Uri.parse("android.resource://" + view?.context.packageName + "/drawable/avatar")
                accountImage?.putFile(imageURI)!!.addOnSuccessListener{
                    accountImage?.downloadUrl!!.addOnCompleteListener { task ->
                        var imageURL = task.result
                        val accountConInformation: Account = Account(
                            accountName?.text.toString(),
                            accountEmail?.text.toString(),
                            accountPhone?.text.toString(),
                            accountFoundBy?.selectedItem.toString(),
                            imageURL.toString()
                        )
                        datosAFirestore(accountConInformation)
                    }
                }
            }

        }

        textViewColeccion?.setOnClickListener{
            listener?.callCollectionFragment()
        }

    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try {
            listener = context as Listener
        } catch (e: ClassCastException){
            throw ClassCastException(context.toString() + "debes implementar la interface")
        }

    }

    fun datosAFirestore(account: Account){
        myFirestoreDB.collection("accounts")
            .add(account)
            .addOnSuccessListener { documentReference ->
                Log.i("TAG_FIREBASE: ", "${documentReference.id}")
            }
            .addOnFailureListener { exception ->
                Log.e("TAG_FIREBASE: ", exception.toString())
            }
    }

    interface Listener{
        fun callCollectionFragment()
    }

    companion object {

        fun newInstance() : FormViewFragment {
            val fragment = FormViewFragment()
            return fragment
        }
    }

}
