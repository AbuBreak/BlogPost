package com.malikbreak.blogpost.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.databinding.ActivityMainBinding
import com.malikbreak.blogpost.main.adapter.OptionAdapter
import com.malikbreak.blogpost.main.model.OptionItem

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    private lateinit var options: List<OptionItem>
    private var adapter: RecyclerView.Adapter<OptionAdapter.OptionViewHolder>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        options = ArrayList()
        options = setData()

        layoutManager = GridLayoutManager(this, 2)
        mainBinding.recyclerView.layoutManager = layoutManager

        adapter = OptionAdapter(this, options)
        mainBinding.recyclerView.adapter = adapter
    }

    private fun setData(): List<OptionItem> {
        val array: ArrayList<OptionItem> = ArrayList()
        array.add(OptionItem(R.drawable.post, "Posts"))
        array.add(OptionItem(R.drawable.todo, "Todos"))
        array.add(OptionItem(R.drawable.user, "Users"))
        return array
    }
}