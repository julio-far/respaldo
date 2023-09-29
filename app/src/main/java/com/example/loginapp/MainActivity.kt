package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// con este boton sale por completo de la application
        val salirButton: Button = findViewById(R.id.button_salir)
        salirButton.setOnClickListener{
            finishAffinity()
        }
        //con este boton nos dirigira al MENU DICCIONARIO
        val dicButton= findViewById<ImageButton>(R.id.ButtonDic)
        dicButton.setOnClickListener{
            //crea una intencion para ingresar a la DiccionarioActivity
            val intent =Intent(this,DiccionarioActivity::class.java)
            startActivity(intent)
        }

        val juButton = findViewById<ImageButton>(R.id.imageButton6)
        juButton.setOnClickListener{
            val intent = Intent(this,Juegos::class.java)
            startActivity(intent)
        }
    }
}