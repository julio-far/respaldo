package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class DiccionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diccionario)

        val retMen1 = findViewById<ImageButton>(R.id.imageButtonR)
        retMen1.setOnClickListener{
          val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}