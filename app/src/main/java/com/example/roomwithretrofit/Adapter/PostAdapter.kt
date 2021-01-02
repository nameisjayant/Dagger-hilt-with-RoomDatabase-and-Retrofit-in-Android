package com.example.roomwithretrofit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomwithretrofit.Model.Post
import com.example.roomwithretrofit.R

class PostAdapter(private val context: Context,private var postList:ArrayList<Post>) :RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post=postList[position]
        holder.body.text=post.body
    }
    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val body:TextView = itemView.findViewById(R.id.body)
    }

    fun setPost(postList: ArrayList<Post>){
        this.postList=postList
        notifyDataSetChanged()
    }
}