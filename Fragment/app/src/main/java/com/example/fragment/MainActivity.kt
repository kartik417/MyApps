package com.example.fragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fragment.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnClock = findViewById<Button>(R.id.btnClock)
        val btnExam = findViewById<Button>(R.id.btnExam)
        val btnValidate = findViewById<Button>(R.id.btnValidate)
        btnClock.setOnClickListener {
            // Replace the current fragment with the Clock fragment
            replaceFrameWithFragment(Clock())

        }
        btnExam.setOnClickListener {
            replaceFrameWithFragment(DateSheet())
        }
        btnValidate.setOnClickListener {
            replaceFrameWithFragment(LoginFragment())
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private fun MainActivity.replaceFrameWithFragment(frag: Fragment) {
    val fragManager = supportFragmentManager
    val fragTransaction = fragManager.beginTransaction()
    fragTransaction.replace(R.id.frameLayout,frag)
    fragTransaction.commit()
}
