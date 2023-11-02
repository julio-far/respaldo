package com.example.loginapp

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.loginapp.databinding.ActivityNumerosBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class Numeros : AppCompatActivity() {
    lateinit var binding: ActivityNumerosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumerosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonBuscar1.setOnClickListener{


            val progressDialog = ProgressDialog(this,)
            progressDialog.setMessage("fetching image...")
            progressDialog.setCancelable(false)
            progressDialog.show()


            val imageName = binding.etImageId.text.toString()
            val storageRef = FirebaseStorage.getInstance().reference.child("Numeros/$imageName.png")

            val localfile= File.createTempFile("tempImage","png")
            storageRef.getFile(localfile).addOnSuccessListener {


                if (progressDialog.isShowing)
                    progressDialog.dismiss()


                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                binding.imageView.setImageBitmap(bitmap)


            } .addOnFailureListener {
                if (progressDialog.isShowing)
                    progressDialog.dismiss()

                Toast.makeText(this,"failed to retrive the image", Toast.LENGTH_SHORT).show()
            }

        }
        //con este boton nos dirigira al apartado de diccionario menu
        val abc= findViewById<ImageButton>(R.id.imageButton4)
        abc.setOnClickListener{
            //crea una intencion para ingresar a la menu diccionario
            val intent = Intent(this,DiccionarioActivity::class.java)
            startActivity(intent)
        }
    }
}
