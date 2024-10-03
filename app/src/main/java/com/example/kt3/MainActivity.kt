package com.example.kt3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextText)



        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener { myViewModel.changeString(editText.text.toString()) }

        myViewModel.liveData.observe(this, Observer {
            when(it) {
                "1" -> supportFragmentManager.beginTransaction().replace(R.id.container1, fragment1).addToBackStack(null).commit()
                "2" -> supportFragmentManager.beginTransaction().replace(R.id.container1, fragment2).addToBackStack(null).commit()
                "3" -> supportFragmentManager.beginTransaction().replace(R.id.container1, fragment3).addToBackStack(null).commit()
            }
        })

    }

}


val fragment1:BlankFragment = BlankFragment()
val fragment2:BlankFragment2 = BlankFragment2()
val fragment3:BlankFragment3 = BlankFragment3()