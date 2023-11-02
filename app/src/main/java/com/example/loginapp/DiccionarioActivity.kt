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
        retMen1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //con este boton nos dirigira al apartado de abecedario
        val abcd = findViewById<ImageButton>(R.id.imageButton2)
        abcd.setOnClickListener {
            //crea una intencion para ingresar a la abecedario
            val intent = Intent(this, Abecedario::class.java)
            startActivity(intent)
        }
        //con este boton nos dirigira al apartado de abecedario
        val nun = findViewById<ImageButton>(R.id.imageButton5)
        nun.setOnClickListener {
            //crea una intencion para ingresar a Numeros
            val intent = Intent(this,Numeros::class.java)
            startActivity(intent)
        }
    }
}