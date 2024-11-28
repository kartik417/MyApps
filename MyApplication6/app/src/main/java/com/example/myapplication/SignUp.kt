package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.email)
        val name = findViewById<EditText>(R.id.name)
        val password = findViewById<EditText>(R.id.password);
        val id = findViewById<EditText>(R.id.uniqueId)

        val signup = findViewById<Button>(R.id.btnSignUp)
        val txt = findViewById<TextView>(R.id.txt);

        txt.setOnClickListener{
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
        signup.setOnClickListener{
            val txtName = name.text.toString()
            val txtEmail = email.text.toString()
            val txtPassword = password.text.toString()
            val txtId = id.text.toString()
            val user = User(txtName,txtEmail,txtPassword,txtId)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(txtId).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"Signed Up Successfully",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}