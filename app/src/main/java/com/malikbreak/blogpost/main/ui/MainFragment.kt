package com.malikbreak.blogpost.main.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.core.base.BaseFragment
import com.malikbreak.blogpost.databinding.FragmentMainBinding
import com.malikbreak.blogpost.main.adapter.OptionAdapter
import com.malikbreak.blogpost.main.model.OptionItem


class MainFragment : BaseFragment<FragmentMainBinding>(), OptionAdapter.OnItemClickListener{

    private lateinit var options: List<OptionItem>
    private var adapter: RecyclerView.Adapter<OptionAdapter.OptionViewHolder>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun getViewBinding(): FragmentMainBinding =
        FragmentMainBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        options = ArrayList()
        options = setData()

        layoutManager = GridLayoutManager(activity,2)
        binding.recyclerView.layoutManager = layoutManager

        adapter = OptionAdapter(this, options, this)
        binding.recyclerView.adapter = adapter

    }

    private fun setData(): List<OptionItem> {
        val array: ArrayList<OptionItem> = ArrayList()
        array.add(OptionItem(R.drawable.post, "Posts"))
        array.add(OptionItem(R.drawable.todo, "Todos"))
        array.add(OptionItem(R.drawable.user, "Users"))
        return array
    }

    override fun onItemClick(position: Int) {
        view?.let { Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_postsFragment) }
    }


}