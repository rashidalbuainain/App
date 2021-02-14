package com.example.saproject3

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  val textSignUp = findViewById<TextView>(R.id.textSignUp)

        val s : SharedPreferences = this.getSharedPreferences("Prefernce", MODE_PRIVATE)
        val email = s.getString("Username", "1,2,3")
        val password = s.getString("password", "1,2,3")

        buttonSubmit.setOnClickListener{
           var username = editText.text.toString()
            Toast.makeText(this, "username is: $username" , Toast.LENGTH_LONG).show()
           // var password = editTextPassword.text.toString()
         //   Toast.makeText(this, "Your Password is: $password" , Toast.LENGTH_LONG).show()


            var myIntent = Intent(this, HomeActivity::class.java)
            startActivity(myIntent)
        }

        //textSignUp.setOnClickListener{


            var myIntent = Intent(this, SignUpActivity::class.java)
            startActivity(myIntent)
        }


    }
