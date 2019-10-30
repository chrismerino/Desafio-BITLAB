package com.cristian.desafiobitlab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class SuccessViewFragment : Fragment() {

    var listener: ListenerFragment2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_success_view, container, false)
    }

    interface ListenerFragment2{

        fun obtenerFragment(nombre: String){

        }
    }

    companion object {

        fun newInstance() = SuccessViewFragment
    }











}
