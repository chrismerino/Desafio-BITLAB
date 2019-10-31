/*
 * Copyright (c) 2019.  Cristian Merino, All rights reserved.
 * https://linkedin.com/chrismerino
 */

package sv.edu.bitlab.desafio.cristian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sv.edu.bitlab.desafio.cristian.R


class MainActivity : AppCompatActivity(), FormViewFragment.Listener,
    SuccessViewFragment.ListenerFragment2 {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val mostrarFragment = FormViewFragment()

        val builder = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_main_activity, mostrarFragment)
            // .addToBackStack(null)
            builder.commit()
    }



    override fun callMyFragment() {
        val showMyNewFragment = SuccessViewFragment()
        val builder = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_main_activity, showMyNewFragment)
            .addToBackStack(null)
            builder.commit()

    }

}
