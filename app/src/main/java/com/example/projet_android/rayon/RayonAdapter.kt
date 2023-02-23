package com.example.projet_android.rayon

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_android.R
import com.example.projet_android.listProducts.ListProductActivity

class RayonAdapter (val rayons: ArrayList<Rayon>):RecyclerView.Adapter<RayonAdapter.ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewTitle = view.findViewById<TextView>(R.id.textViewTitle)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutContent)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_rayon, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rayon = rayons.get(position)
        holder.textViewTitle.text=rayon.title
        holder.layoutContent.setOnClickListener {
            val intent = Intent(holder.layoutContent.context, ListProductActivity::class.java)
            intent.putExtra("url", rayon.url)
            intent.putExtra("title", rayon.title)
            holder.layoutContent.context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return rayons.size
    }


}
