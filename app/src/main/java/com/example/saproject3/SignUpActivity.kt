package com.example.saproject3

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val editTextName = findViewById<EditText>(R.id.edUserName)
        val edEmail = findViewById<EditText>(R.id.edEmail)
        val ed1 = findViewById<EditText>(R.id.edPassword)
        val ed2 = findViewById<EditText>(R.id.edPassword2)
        val b = findViewById<Button>(R.id.button)
      //  val s : SharedPreferences = this.getSharedPreferences("Prefernce", Context.MODE_PRIVATE)
        b?.setOnClickListener {
            val name:String = editTextName.text.toString()
            val email:String = edEmail.text.toString()
            val password:String = ed1.text.toString()
            val password2:String = ed2.text.toString()
          //  val editer:SharedPreferences.Editor = s.edit()

            if (name.trim().equals(""))
                Toast.makeText(this,"Please Enter Name", Toast.LENGTH_LONG).show()
         else   if (email.trim().equals(""))
                Toast.makeText(this,"Please Enter Email", Toast.LENGTH_LONG).show()
            else   if (password.trim().equals(""))
                Toast.makeText(this,"Please Enter Password", Toast.LENGTH_LONG).show()
            else   if (password2.trim().equals(""))
                Toast.makeText(this,"Please Enter Confirm Password", Toast.LENGTH_LONG).show()
            else   if (password2.trim().equals(password.trim()).not())
                Toast.makeText(this,"Please Enter The Confirmed Password", Toast.LENGTH_LONG).show()

            else
            {

             /*   editer.putString("Username", name)
                editer.putString("email", email)
                editer.putString("password", password)
                editer.apply()
                editer.commit()

              */
                val intent = Intent(this, BookDetails2 ::class.java)
                intent.putExtra("Username", name)
                intent.putExtra("email", email)
                intent.putExtra("password", password)

            startActivity(intent)
            }
        }
    }
}