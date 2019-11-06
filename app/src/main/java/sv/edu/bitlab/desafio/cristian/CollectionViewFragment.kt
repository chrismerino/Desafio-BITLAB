/*
 * Copyright (c) 2019.  Cristian Merino, All rights reserved.
 * https://linkedin.com/chrismerino
 */

package sv.edu.bitlab.desafio.cristian

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import sv.edu.bitlab.desafio.cristian.DataModel.Account


class CollectionViewFragment : Fragment() {

    var listener: ListenerFragment2? = null

    val db = FirebaseFirestore.getInstance()
    var collectRef: CollectionReference = db.collection("accounts")
    var adapter: AdapterFirebaseData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_collection_view, container, false)


        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callRecyclerView()

    }

    fun callRecyclerView(){
        var query: Query= collectRef.orderBy("accountName", Query.Direction.DESCENDING)
        var options : FirestoreRecyclerOptions<Account> = FirestoreRecyclerOptions.Builder<Account>()
            .setQuery(query, Account::class.java)
            .build()

        adapter = AdapterFirebaseData(options)

        var recycclerView = view?.findViewById<RecyclerView>(R.id.rv_firebase)
        recycclerView?.setHasFixedSize(true)
        recycclerView?.layoutManager = LinearLayoutManager(view?.context)
        recycclerView?.adapter = adapter
    }

    override fun onStart(){
        super.onStart()
        adapter?.startListening()
    }

    override fun onStop(){
        super.onStop()
        adapter?.stopListening()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface ListenerFragment2{
    }

    companion object {

        fun newInstance() = CollectionViewFragment
    }











}
