package com.example.messgenger

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val context: Activity, val userList: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
        val user = userList[position]
        holder.name.text = user.name.toString()
        holder.status.text = user.status.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val status: TextView
        init {
            name = itemView.findViewById(R.id.nameTxt1)
            status = itemView.findViewById(R.id.statusTxt)
        }


    }
}