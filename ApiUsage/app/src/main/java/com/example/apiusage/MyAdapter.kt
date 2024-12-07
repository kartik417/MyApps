package com.example.apiusage

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Activity, private val productList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        lateinit var mListner: onSetItemClickListner

    interface onSetItemClickListner {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(listner: onSetItemClickListner) {
        mListner = listner
    }


    class MyViewHolder(itemView: View, listner: onSetItemClickListner) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ShapeableImageView
        var price: TextView
        var rating: TextView


        init {
            title = itemView.findViewById(R.id.productName)
            image = itemView.findViewById(R.id.productImage)
            price = itemView.findViewById(R.id.productPrice)
            rating = itemView.findViewById(R.id.productRating)
            itemView.setOnClickListener {
                listner.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachview,parent,false)
        return MyViewHolder(itemView,mListner)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.title.text = currentItem.title
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
        holder.price.text = "Rs: " + currentItem.price.toString()
        holder.rating.text = "Ratings:" + currentItem.rating.toString()


    }
}