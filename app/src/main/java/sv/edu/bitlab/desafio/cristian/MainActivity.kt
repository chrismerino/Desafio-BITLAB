/*
 * Copyright (c) 2019.  Cristian Merino, All rights reserved.
 * https://linkedin.com/chrismerino
 */

package sv.edu.bitlab.desafio.cristian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.AnimatorRes
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class MainActivity : AppCompatActivity(), FormViewFragment.Listener,
    CollectionViewFragment.ListenerFragment2 {

    private var mStorageRef: StorageReference? = null
    private var fireStoreDatabase: FirebaseFirestore? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Inicializacion STORAGE / FireStore
        mStorageRef = FirebaseStorage.getInstance().getReference()

        // Inicializacion FIRESTORE
        fireStoreDatabase = FirebaseFirestore.getInstance()




        val mostrarFragment = FormViewFragment()

        val builder = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_main_activity, mostrarFragment)
            // .addToBackStack(null)
            builder.commit()
    }



    override fun callCollectionFragment() {
        val showMyNewFragment = CollectionViewFragment()
        val builder = supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
            .replace(R.id.fragment_container_main_activity, showMyNewFragment)
            .addToBackStack(null)
            builder.commit()

    }

}
