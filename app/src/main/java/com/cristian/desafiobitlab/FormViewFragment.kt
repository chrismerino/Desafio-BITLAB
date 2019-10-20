package com.cristian.desafiobitlab

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_form_view.view.*


class FormViewFragment : Fragment() {

    val TAG = "FormViewFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        // Inflate the layout for this fragment

        val view: View = inflater!!.inflate(R.layout.fragment_form_view, container, false)

        view.bntEnviar.setOnClickListener{ view ->
            Log.d("btnEnviar", "Selected")
        }
        return view

        //return inflater.inflate(R.layout.fragment_form_view, container, false)
    }

    private fun callFragment() {
    }





}
