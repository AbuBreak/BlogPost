package com.malikbreak.blogpost.main.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.core.base.BaseFragment
import com.malikbreak.blogpost.databinding.FragmentMainBinding


class MainFragment : BaseFragment<FragmentMainBinding>() {


    override fun getViewBinding(): FragmentMainBinding =
        FragmentMainBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.postButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_postsFragment)
        }

        binding.todosButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_todosFragment)
        }

        binding.userButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_usersFragment)
        }

    }

}