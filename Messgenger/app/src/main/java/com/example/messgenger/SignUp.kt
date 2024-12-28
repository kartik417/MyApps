package com.example.messgenger

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        val databaseReference = FirebaseDatabase.getInstance().getReference("users")
        val nameTxt = findViewById<EditText>(R.id.nameEdt)
        val emailTxt = findViewById<EditText>(R.id.emailEdt)
        val passwordTxt = findViewById<EditText>(R.id.passwordEdt)
        val btn = findViewById<Button>(R.id.btnSignUp)
        btn.setOnClickListener{
            val txtName = nameTxt.text.toString()
            val txtPassword = passwordTxt.text.toString()
            val txtEmail = emailTxt.text.toString()
            val user = User(txtName, txtEmail, txtPassword)
            databaseReference.child(txtName).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, UserDetails::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to register user", Toast.LENGTH_SHORT).show()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}