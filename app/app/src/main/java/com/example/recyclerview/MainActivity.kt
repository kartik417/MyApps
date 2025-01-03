package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var newsArrayList : ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        val newsHeading = arrayOf(  "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra")

        val newContent = arrayOf(
          getString(R.string.news_content),
          getString(R.string.news_content),
          getString(R.string.news_content),
          getString(R.string.news_content),
          getString(R.string.news_content),
          getString(R.string.news_content),
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = ArrayList<News>()
        val newsImage = intArrayOf(R.drawable.news0,
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.news3,
            R.drawable.news4,
            R.drawable.news5)

        for(index in newsImage.indices){
            val newsItem = News(newsHeading[index],newsImage[index],newContent[index])
            newsArrayList.add(newsItem)
        }
        var myAdapter = MyAdapter(this,newsArrayList)
        recyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClicking(position: Int) {
                val intent = Intent(this@MainActivity,NewsDetails::class.java)
                intent.putExtra("heading",newsHeading[position])
                intent.putExtra("imgId",newsImage[position])
                intent.putExtra("newsContent",newContent[position])
                startActivity(intent)
            }

        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}