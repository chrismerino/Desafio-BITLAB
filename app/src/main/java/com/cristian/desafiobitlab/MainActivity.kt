package com.cristian.desafiobitlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(), FormViewFragment.Listener, SuccessViewFragment.ListenerFragment2 {


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
