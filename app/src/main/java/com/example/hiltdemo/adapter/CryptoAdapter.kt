package com.example.hiltdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hiltdemo.R
import com.example.hiltdemo.data.Crypto

class CryptoAdapter(private val crypto:List<Crypto>):RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {




    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){

        fun bind(index:Crypto){
            // Here, we are using Glide library to
            // load the image into ImageView

            Glide.with(itemView.context)
                .load(index.image).dontAnimate()
                .into(itemView.findViewById(R.id.image))
            // Setting name of cryptocurrency to TextView
            itemView.findViewById<TextView>(R.id.cryptocurrency).text = index.name

        }
    }

    override fun getItemCount(): Int {
         return crypto.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflating list data from list_item to view

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Bind the inflated data
        holder.bind(crypto[position])

    }


}