package com.example.projet_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.projet_android.rayon.RayonActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderTitle(getString(R.string.first_menu))

        val buttonLogin=findViewById<Button>(R.id.buttonInfo)
        buttonLogin.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentActivity::class.java)
            startActivity(newIntent)
        })
        val buttonSignup=findViewById<Button>(R.id.buttonProduits)
        buttonSignup.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, RayonActivity::class.java)
            startActivity(newIntent)
        })
    }
}