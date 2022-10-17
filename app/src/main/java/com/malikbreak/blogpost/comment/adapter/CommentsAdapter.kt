package com.malikbreak.blogpost.comment.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.comment.model.CommentModelItem

class CommentsAdapter(
    private var context: Context,
    private var comments: List<CommentModelItem>
) : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false)
        return CommentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.postID.text = comments[position].postId.toString()
        holder.postBody.text = comments[position].body
        holder.name.text = comments[position].name
        holder.email.text = comments[position].email


    }

    override fun getItemCount(): Int {
        return comments.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCommentList(comments: List<CommentModelItem>){
        this.comments = comments
        notifyDataSetChanged()
    }

    class CommentsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postID : TextView = view.findViewById(R.id.postIdTV)
        val postBody : TextView = view.findViewById(R.id.postBodyTV)
        val name : TextView = view.findViewById(R.id.nameTV)
        val email : TextView = view.findViewById(R.id.emailTV)
    }


}