package com.example.saproject3

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    public var image: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val t1 = findViewById<TextView>(R.id.textView3)
        val t2 = findViewById<TextView>(R.id.textView4)
        val t3 = findViewById<TextView>(R.id.textView5)
        val image = findViewById<ImageView>(R.id.imageView)

      //  val email = Intent.getString("Username", "1,2,3")
      //  val password = s.getString("password", "1,2,3")

        t1.setOnClickListener{
            if (image.visibility == View.VISIBLE) {
                image.visibility = View.INVISIBLE
            } else {
                image.visibility = View.VISIBLE
            }
            t3.setText("t1 clicklisner")
            t3.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50F)
            t3.setTextColor(Color.parseColor("#AEFF9800"))
           // image.setImageResource(R.drawable.email)
        }
        image.setOnClickListener{
           capturePhoto()
        }

        var bundle :Bundle ?=intent.extras
        var message = bundle!!.getString("Username") // 1
        t1.setText(message)
        var message1 = bundle!!.getString("email") // 1
        t2.setText(message1)
       // var strUser: String = intent.getStringExtra("value") // 2
        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    val REQUEST_CODE = 200

    fun capturePhoto() {

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null){
            image?.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }
}