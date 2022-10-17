package com.malikbreak.blogpost.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.main.model.OptionItem


class OptionAdapter(
    var options: List<OptionItem>,
) :
    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.name.text = options[position].name
        holder.img.setImageResource(options[position].icon)

        when (options[position].name) {
            "Posts" -> holder.cardView.setOnClickListener {
                it.findNavController().navigate(R.id.action_mainFragment_to_postsFragment)
            }
            "Todos" -> holder.cardView.setOnClickListener {
                it.findNavController().navigate(R.id.action_mainFragment_to_todosFragment)
            }
            "Users" -> holder.cardView.setOnClickListener {
                it.findNavController().navigate(R.id.action_mainFragment_to_usersFragment)
            }
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }

    inner class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.itemImg)
        var name: TextView = itemView.findViewById(R.id.itemName)
        var cardView: CardView = itemView.findViewById(R.id.cardView)


    }


}