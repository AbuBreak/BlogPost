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
import com.malikbreak.blogpost.main.ui.MainFragment

class OptionAdapter(
    var context: MainFragment,
    var options: List<OptionItem>,
    var listener: OnItemClickListener
) :
    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() , View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.name.text = options[position].name
        holder.img.setImageResource(options[position].icon)


    }

    override fun getItemCount(): Int {
        return options.size
    }

    inner class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {
        var img: ImageView = itemView.findViewById(R.id.itemImg)
        var name: TextView = itemView.findViewById(R.id.itemName)
        var cardView: CardView = itemView.findViewById(R.id.cardView)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION){
               listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{ fun onItemClick(position: Int) }

    override fun onClick(v: View?) {
        if (v != null) {
            listener.onItemClick(v.id)
        }
    }
}