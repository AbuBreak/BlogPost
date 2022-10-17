package com.malikbreak.blogpost.post.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.post.model.PostModelItem

class PostsAdapter(
    private var context: Context,
    private var posts: List<PostModelItem>
) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.postTitle.text = posts[position].title
        holder.userId.text = posts[position].userId.toString()
        holder.postBody.text = posts[position].body

        holder.parent.setOnClickListener{
            it.findNavController().navigate(R.id.action_postsFragment_to_commentsFragment)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setPostList(posts: List<PostModelItem>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class PostsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var postTitle: TextView = view.findViewById(R.id.titleTV)
        var userId: TextView = view.findViewById(R.id.userIdTV)
        var postBody: TextView = view.findViewById(R.id.bodyTV)
        var parent : CardView = view.findViewById(R.id.postCardView)
    }


}