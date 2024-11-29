package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelCome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wel_come)

        val name = intent.getStringExtra(MainActivity.KEY1)
        val email = intent.getStringExtra(MainActivity.KEY2)
        val id = intent.getStringExtra(MainActivity.KEY3)

        val txtWelcome = findViewById<TextView>(R.id.welcomeTxt)
        val emailTxt = findViewById<TextView>(R.id.emailTxt)
        val idTxt = findViewById<TextView>(R.id.uniqueIdTxt)

        txtWelcome.text = "Welcome $name"
        emailTxt.text = "Email: $email"
        idTxt.text = "User Id: $id"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}