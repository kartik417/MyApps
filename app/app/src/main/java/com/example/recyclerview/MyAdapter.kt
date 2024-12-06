package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class MyAdapter(val context : Activity, private val newsArrayList : ArrayList<News>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var myListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClicking(position : Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_view,parent,false)
        return MyViewHolder(itemView,myListener)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            var currentItem = newsArrayList[position]
            holder.hTitle.text = currentItem.news
            holder.hImage.setImageResource(currentItem.imgId)
    }
    class MyViewHolder(itemView : View, listener : onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)
        init {
            itemView.setOnClickListener{
                listener.onItemClicking(adapterPosition)
            }
        }

    }
}