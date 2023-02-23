package com.example.projet_android.listProducts

import android.app.AlertDialog
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_android.BaseActivity
import com.example.projet_android.R
import fr.epsi.full_stack.ListProduct
import fr.epsi.full_stack.ListProductAdapter
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class ListProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listproducts)
        showBack()
        setHeaderTitle(intent.getStringExtra("title"))

        val url="https://img.freepik.com/photos-gratuite/rendu-3d-fond-espace-planetes-abstraites-nebuleuse_1048-12994.jpg?w=740&t=st=1673970224~exp=1673970824~hmac=5db29203b7bcddbecb50f50b6bab3920b729055ce5b87aaccc3260362a801f19"
        val listProducts= arrayListOf<ListProduct>()

        val recyclerviewListProducts=findViewById<RecyclerView>(R.id.recyclerviewListProducts)
        recyclerviewListProducts.layoutManager= LinearLayoutManager(this)
        val listProductAdapter=ListProductAdapter(listProducts)
        recyclerviewListProducts.adapter=listProductAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL=intent.getStringExtra("url")
        val request = Request.Builder()
            .url(mRequestURL.toString())
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    AlertDialog.Builder(this@ListProductActivity)
                        .setTitle("Error")
                        .setMessage("Failed to load data")
                        .show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if(data!=null) {
                    val jsListProducts = JSONObject(data)
                    val jsArrayListProducts = jsListProducts.getJSONArray("items")
                    for (i in 0 until jsArrayListProducts.length()) {
                        val js = jsArrayListProducts.getJSONObject(i)
                        val listProduct = ListProduct(
                            js.optString("name", "not found"),
                            js.optString("description", "not found"),
                            js.optString("picture_url", "not found"),
                        )
                        listProducts.add(listProduct)
                        runOnUiThread(Runnable {
                            listProductAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }

        })



    }
}