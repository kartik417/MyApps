package com.example.apiusage

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_details)

       val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val category = intent.getStringExtra("category")
        val price = intent.getDoubleExtra("price",0.0)
        val discount = intent.getDoubleExtra("discount",1.0)
        val rating = intent.getDoubleExtra("rating",5.0)
        val stock = intent.getIntExtra("stock",5)
        val brand = intent.getStringExtra("brand")
        val thumbnail = intent.getStringExtra("thumbnail")


        val productTitleTextView = findViewById<TextView>(R.id.titleTextView)
        val productDescriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
        val productCategoryTextView = findViewById<TextView>(R.id.categoryTextView)
        val productPriceTextView = findViewById<TextView>(R.id.priceTextView)
        val productDiscountTextView = findViewById<TextView>(R.id.discountTextView)
        val productRatingTextView = findViewById<TextView>(R.id.ratingTextView)
        val productStockTextView = findViewById<TextView>(R.id.stockTextView)
        val productBrandTextView = findViewById<TextView>(R.id.brandTextView)
        val productImageView = findViewById<ImageView>(R.id.productImageLarge)

        productTitleTextView.text = title
        productDescriptionTextView.text = description
        productCategoryTextView.text = "Category: $category"
        productPriceTextView.text = "Price: Rs. $price"
        productDiscountTextView.text = "Discount: $discount%"
        productRatingTextView.text = "Rating: $rating"
        productStockTextView.text = "Stock: $stock"
        productBrandTextView.text = "Brand: $brand"
        Picasso.get().load(thumbnail).into(productImageView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}