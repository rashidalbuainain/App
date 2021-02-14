package com.example.saproject3.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.saproject3.MainActivity
import com.example.saproject3.R
import com.example.saproject3.SignUpActivity
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.textDate)
        val buttonSingle: Button = root.findViewById(R.id.SingleRoom)
        buttonSingle.setOnClickListener(){
            val intent = Intent (activity, SignUpActivity::class.java)
            startActivity(intent)
        }
        textView.setText(Calendar.getInstance().time.toString())

        return root
    }
}