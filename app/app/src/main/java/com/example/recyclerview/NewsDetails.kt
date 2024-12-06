package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_details)
        val heading = intent.getStringExtra("heading")
        val imgContent =intent.getIntExtra("imgId",R.drawable.news3)
        val textContent = intent.getStringExtra("newsContent")

        val image = findViewById<ImageView>(R.id.newsImage)
        val newsHeading = findViewById<TextView>(R.id.newsHeading)
        val newsContent = findViewById<TextView>(R.id.newsContent)

        newsHeading.text = heading
        newsContent.text = textContent
        image.setImageResource(imgContent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}