package fr.epsi.full_stack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_android.R
import com.squareup.picasso.Picasso

class ListProductAdapter(val listProducts: ArrayList<ListProduct>):RecyclerView.Adapter<ListProductAdapter.ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewDescription = view.findViewById<TextView>(R.id.textViewDescription)
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewProduct)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutContent)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_listproducts, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listProduct = listProducts.get(position)
        holder.textViewName.text=listProduct.name
        holder.textViewDescription.text=listProduct.description
        Picasso.get().load(listProduct.imgUrl).into(holder.imageViewProduct)
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.layoutContent.context,listProduct.name,Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }
}
