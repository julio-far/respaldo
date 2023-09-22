package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Auth
        auth = Firebase.auth



        //manda al activity seleccioando por el texto
        val loginText: TextView = findViewById(R.id.textView_login_now)
        loginText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // lets get email and password from the user
        performSignUp()

    }
private  fun performSignUp(){
    val email= findViewById<EditText>(R.id.editText_email_register)
    val  passwod =findViewById<EditText>(R.id.editText_password_register)

    if(email.text.isEmpty() || passwod.text.isEmpty()){
        Toast.makeText(this, "please fill all Fields", Toast.LENGTH_SHORT)
            .show()
        return
    }

    val inputEmail = email.text.toString()
    val inputPassword = passwod.text.toString()

    auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, let move to the next activity i.e MainActivity

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)


            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT,).show()

}
        }
        .addOnFailureListener{
            Toast.makeText(this,"Error occurred ${it.localizedMessage}",Toast.LENGTH_SHORT)
                .show()
        }
}
}
