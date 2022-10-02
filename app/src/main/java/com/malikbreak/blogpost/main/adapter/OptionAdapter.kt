package com.malikbreak.blogpost.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.main.model.OptionItem

class OptionAdapter(var context: Context, var options: List<OptionItem>) :
    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.name.text = options[position].name
        holder.img.setImageResource(options[position].icon)
    }

    override fun getItemCount(): Int {
        return options.size
    }


    class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var img: ImageView
         var name: TextView

        init {
            img = itemView.findViewById(R.id.itemImg)
            name = itemView.findViewById(R.id.itemName)
        }
    }

}