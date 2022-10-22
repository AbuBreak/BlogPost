package com.malikbreak.blogpost.postsByUser.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.post.model.PostModelItem

class PostsByUserAdapter(
    private var context: Context,
    private var usersPost: List<PostModelItem>

) : RecyclerView.Adapter<PostsByUserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.user_post_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = usersPost[position].userId.toString()
        holder.title.text = usersPost[position].title
        holder.body.text = usersPost[position].body
    }

    override fun getItemCount(): Int {
        return usersPost.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUsersPostList(posts: List<PostModelItem>) {
        this.usersPost = posts
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userId: TextView = itemView.findViewById(R.id.userIdTV)
        var title: TextView = itemView.findViewById(R.id.titleTV)
        var body: TextView = itemView.findViewById(R.id.bodyTV)
    }


}