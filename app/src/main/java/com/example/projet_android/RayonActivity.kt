package com.example.projet_android

import android.app.AlertDialog
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class RayonActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rayon)
        showBack()
        setHeaderTitle(getString(R.string.title_rayons))

        val url="https://img.freepik.com/photos-gratuite/rendu-3d-fond-espace-planetes-abstraites-nebuleuse_1048-12994.jpg?w=740&t=st=1673970224~exp=1673970824~hmac=5db29203b7bcddbecb50f50b6bab3920b729055ce5b87aaccc3260362a801f19"
        val rayons= arrayListOf<Rayon>()

        val recyclerviewRayons=findViewById<RecyclerView>(R.id.recyclerviewRayons)
        recyclerviewRayons.layoutManager= LinearLayoutManager(this)
        val studentAdapter=RayonAdapter(rayons)
        recyclerviewRayons.adapter=studentAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="https://www.ugarit.online/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    AlertDialog.Builder(this@RayonActivity)
                        .setTitle("Error")
                        .setMessage("Failed to load data")
                        .show()
                }
            }


            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if(data!=null) {
                    val jsRayons = JSONObject(data)
                    val jsArrayRayons = jsRayons.getJSONArray("items")
                    for (i in 0 until jsArrayRayons.length()) {
                        val js = jsArrayRayons.getJSONObject(i)
                        val student = Rayon(
                            js.optString("category_id", "not found"),
                            js.optString("title", "not found"),
                            js.optString("products_url", "not found"),

                        )
                        rayons.add(student)
                        runOnUiThread(Runnable {
                            studentAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }

        })



    }
}