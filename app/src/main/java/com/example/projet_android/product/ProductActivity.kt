package com.example.projet_android.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_android.BaseActivity
import com.example.projet_android.R
import com.squareup.picasso.Picasso

class ProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        showBack()
        setHeaderTitle(intent.getStringExtra("name"))

        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)
        val imageViewProduct = findViewById<ImageView>(R.id.imageViewProduct)

        textViewDescription.text = intent.getStringExtra("description")
        var imgUrl = intent.getStringExtra("imgUrl")
        Picasso.get().load(imgUrl).into(imageViewProduct)

    }
}