package com.malikbreak.blogpost.main.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.main.model.OptionItem

 class OptionAdapter(var context: Context, var options: List<OptionItem>) :
    BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var optionTV: TextView
    private lateinit var optionIV: ImageView

    override fun getCount(): Int {
       return options.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView

        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {

            convertView = layoutInflater!!.inflate(R.layout.grid_item, null)
        }

        optionIV = convertView!!.findViewById(R.id.gridImg)
        optionTV = convertView.findViewById(R.id.itemName)

        optionIV.setImageResource(options[position].icon)
        optionTV.text = options[position].name

        return convertView
    }


}