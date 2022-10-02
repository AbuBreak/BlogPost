package com.malikbreak.blogpost.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.databinding.ActivityMainBinding
import com.malikbreak.blogpost.main.adapter.OptionAdapter
import com.malikbreak.blogpost.main.model.OptionItem

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

}