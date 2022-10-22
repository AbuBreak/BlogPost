package com.malikbreak.blogpost.user.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikbreak.blogpost.core.base.BaseFragment
import com.malikbreak.blogpost.databinding.FragmentUsersBinding
import com.malikbreak.blogpost.user.adapter.UsersAdapter
import com.malikbreak.blogpost.user.model.UserModelItem
import com.malikbreak.blogpost.user.viewmdoel.UserViewModel

class UsersFragment : BaseFragment<FragmentUsersBinding>() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var adapter: UsersAdapter
    private  var users: List<UserModelItem>? =null

    override fun getViewBinding(): FragmentUsersBinding =
        FragmentUsersBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.getUsers()
        users?.let { adapter.setUserList(it) }

        userViewModel.usersMutableLiveData.observe(viewLifecycleOwner){

            adapter= UsersAdapter(requireContext(),it)
            binding.userRecycler.adapter = adapter
            binding.userRecycler.layoutManager = LinearLayoutManager(activity)
        }
    }



}