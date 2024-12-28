package com.example.messgenger

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UserDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_details)
        val databaseReference = FirebaseDatabase.getInstance().getReference("users")
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val userList = ArrayList<User>()
        val adapter = UserAdapter(this, userList)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

       databaseReference.addValueEventListener(object : ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               userList.clear()
               if (snapshot.exists()){
                   for(userSnapshot in snapshot.children){
                    val user = userSnapshot.getValue(User::class.java)
                       if (user != null) {
                           userList.add(user)
                       }

                   }
                   adapter.notifyDataSetChanged()
               }
           }

           override fun onCancelled(error: DatabaseError) {
               Toast.makeText(this@UserDetails, "Failed to fetch data", Toast.LENGTH_SHORT).show()
           }

       })





            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
