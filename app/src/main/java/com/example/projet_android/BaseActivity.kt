package com.example.projet_android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Epsi G2","################ onCreate :"+javaClass.simpleName)
    }

    override fun onStart() {
        super.onStart()
        Log.i("Epsi G2","################ onStart :"+javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Epsi G2","################ onResume :"+javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Log.i("Epsi G2","################ onPause :"+javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        Log.i("Epsi G2","################ onStop :"+javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Epsi G2","################ onDestroy :"+javaClass.simpleName)
    }

    override fun finish() {
        super.finish()
        Log.i("Epsi G2","################ finish :"+javaClass.simpleName)
    }

    fun setHeaderTitle(title: String?) {
        val textView = findViewById<TextView>(R.id.textViewTitle)
        textView.setText(title)
    }

    fun showBack() {
        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility = View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    fun openInBrowser(view: View) {
        val url = "https://www.epsi.fr/" // Remplacez l'URL par l'URL que vous souhaitez ouvrir
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

}