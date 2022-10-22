package com.malikbreak.blogpost.user.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.user.model.UserModelItem

class UsersAdapter(
    private var context: Context,
    private var users: List<UserModelItem>
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userId.text = users[position].id.toString()
        holder.userName.text = users[position].username
        holder.userEmail.text = users[position].email
       holder.parent.setOnClickListener {
           it.findNavController().navigate(R.id.action_usersFragment_to_userPostsFragment)
       }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUserList(users: List<UserModelItem>) {
        this.users = users
        notifyDataSetChanged()
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userId: TextView = itemView.findViewById(R.id.userIdTV)
        var userName: TextView = itemView.findViewById(R.id.usernameTV)
        var userEmail: TextView = itemView.findViewById(R.id.userEmailTV)
        var parent: CardView = itemView.findViewById(R.id.userCardView)
    }


}