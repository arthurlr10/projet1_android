package com.example.projet_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

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
        val student = rayons.get(position)
        holder.textViewTitle.text=student.title
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.layoutContent.context,student.title,Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return rayons.size
    }
}
