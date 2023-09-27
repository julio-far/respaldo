package com.example.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// con este boton sale por completo de la application
        val salirButton: Button = findViewById(R.id.button_salir)
        salirButton.setOnClickListener{
            finishAffinity()
        }
    }
}