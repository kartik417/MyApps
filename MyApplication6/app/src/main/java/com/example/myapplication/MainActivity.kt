package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var databaseReference:DatabaseReference

    companion object{
        const val KEY1 = "com.example.myapplication.MainActivity.name"
        const val KEY2 = "com.example.myapplication.MainActivity.mail"
        const val KEY3 = "com.example.myapplication.MainActivity.id"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val userId = findViewById<EditText>(R.id.userId)
        val password = findViewById<EditText>(R.id.password1)
        val signInBtn = findViewById<Button>(R.id.SignInButton)
        signInBtn.setOnClickListener {
           val txtUserId = userId.text.toString()
            val txtPassword = userId.text.toString()

            if(txtUserId.isNotEmpty()){
                readUserId(txtUserId)
            }else{
                Toast.makeText(this,"Empty password",Toast.LENGTH_SHORT).show()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun readUserId(userId:String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(userId).get().addOnSuccessListener {
            if(it.exists()){
                val dbName = it.child("name").value.toString()
                val dbEmail = it.child("email").value.toString()
                val dbUserId = it.child("id").value.toString()
                val intentWelcome = Intent(this,WelCome::class.java)
                intentWelcome.putExtra(KEY1,dbName)
                intentWelcome.putExtra(KEY2,dbEmail)
                intentWelcome.putExtra(KEY3,dbUserId)
                startActivity(intentWelcome)

            }else{
                Toast.makeText(this,"Failed to sign in",Toast.LENGTH_SHORT)
            }
        }


    }


}