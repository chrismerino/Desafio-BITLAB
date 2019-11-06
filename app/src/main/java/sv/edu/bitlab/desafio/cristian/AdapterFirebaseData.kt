/*
 * Copyright (c) 2019.  Cristian Merino, All rights reserved.
 * https://linkedin.com/chrismerino
 */

package sv.edu.bitlab.desafio.cristian

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.extensions.LayoutContainer
import sv.edu.bitlab.desafio.cristian.DataModel.Account

class AdapterFirebaseData(options: FirestoreRecyclerOptions<Account>) :
    FirestoreRecyclerAdapter<Account, AdapterFirebaseData.CollectionHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent,false)

        return CollectionHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionHolder, position: Int, model: Account) {
        holder.apply {
            namens.text = model.accountName
            email.text = model.accountEmail
            phone.text = model.accountPhone
            foundby.text = model.accountFoundOutBy
            imageGlide(image,model.accountImage)

        }
    }

    inner class CollectionHolder( override val containerView: View) : RecyclerView.ViewHolder(containerView),LayoutContainer {
        var namens = containerView.findViewById<TextView>(R.id.textView_nombre_rv)
        var email=containerView.findViewById<TextView>(R.id.textView_email_rv)
        var phone =containerView.findViewById<TextView>(R.id.textView_telefono_rv)
        var foundby = containerView.findViewById<TextView>(R.id.textView_information_rv)
        var image = containerView.findViewById<ImageView>(R.id.imageView_rv)
    }

    fun imageGlide(imageView: ImageView, url: String?){
        Glide.with(imageView).load(url).into(imageView)
    }
}