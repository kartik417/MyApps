package com.example.apiusage

import android.content.Intent
import android.graphics.pdf.models.ListItem
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dummyjson.com/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProducts()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                var responseBody = response.body()
                val productsData = responseBody?.products!!

               myAdapter = MyAdapter(this@MainActivity, productsData)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                myAdapter.setOnItemClickListner(object : MyAdapter.onSetItemClickListner {
                    override fun onItemClick(position: Int) {



                        val intent = Intent(this@MainActivity, ProductDetails::class.java)
                        intent.putExtra("title", productsData[position].title)
                        intent.putExtra("description",productsData[position].description)
                        intent.putExtra("category",productsData[position].category)
                        intent.putExtra("price",productsData[position].price)
                        intent.putExtra("discount",productsData[position].discountPercentage)
                        intent.putExtra("rating",productsData[position].rating)
                        intent.putExtra("stock",productsData[position].stock)
                        intent.putExtra("brand",productsData[position].brand)
                        intent.putExtra("thumbnail",productsData[position].thumbnail)

                        startActivity(intent)
                    }
                })


            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}