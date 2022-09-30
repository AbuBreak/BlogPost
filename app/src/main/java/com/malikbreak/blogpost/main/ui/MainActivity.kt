package com.malikbreak.blogpost.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.databinding.ActivityMainBinding
import com.malikbreak.blogpost.main.adapter.OptionAdapter
import com.malikbreak.blogpost.main.model.OptionItem

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    private var options: ArrayList<OptionItem>? = null
    private var gridView: GridView? = null
    private var adapter: OptionAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        options = ArrayList()
        options = setData()
        adapter = OptionAdapter(options = options!!, context = this@MainActivity)


    }

    private fun setData(): ArrayList<OptionItem> {
        val array: ArrayList<OptionItem> = ArrayList()
        array.add(OptionItem(R.drawable.post, "Posts"))
        array.add(OptionItem(R.drawable.todo, "Todos"))
        array.add(OptionItem(R.drawable.user, "Users"))
        return array
    }
}