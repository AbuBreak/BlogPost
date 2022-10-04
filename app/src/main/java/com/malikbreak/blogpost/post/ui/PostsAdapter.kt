package com.malikbreak.blogpost.post.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.post.model.PostModelItem

class PostsAdapter(
    private var posts: List<PostModelItem>
) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.postTitle.text = posts[position].title
        holder.userId.text = posts[position].userId.toString()
        holder.postBody.text = posts[position].body
    }

    override fun getItemCount(): Int {
        return posts.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setList(posts: List<PostModelItem>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class PostsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var postTitle: TextView = view.findViewById(R.id.titleTV)
        var userId: TextView = view.findViewById(R.id.userIdTV)
        var postBody: TextView = view.findViewById(R.id.bodyTV)
    }


}