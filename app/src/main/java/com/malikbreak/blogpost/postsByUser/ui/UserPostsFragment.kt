package com.malikbreak.blogpost.postsByUser.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikbreak.blogpost.core.base.BaseFragment
import com.malikbreak.blogpost.databinding.FragmentUserPostsBinding
import com.malikbreak.blogpost.post.model.PostModelItem
import com.malikbreak.blogpost.postsByUser.adapter.PostsByUserAdapter
import com.malikbreak.blogpost.postsByUser.viewmodel.PostsUserViewModel

class UserPostsFragment : BaseFragment<FragmentUserPostsBinding>() {

    private lateinit var postUserViewModel: PostsUserViewModel
    private lateinit var adapter: PostsByUserAdapter
    private  var posts: List<PostModelItem>? =null

    override fun getViewBinding(): FragmentUserPostsBinding =
        FragmentUserPostsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postUserViewModel = ViewModelProvider(this)[PostsUserViewModel::class.java]

        postUserViewModel.getUsersPost()

        posts?.let { adapter.setUsersPostList(it) }

        postUserViewModel.postsMutableLiveData.observe(viewLifecycleOwner){
            adapter = PostsByUserAdapter(requireContext(),it)
            binding.userRecycler.adapter = adapter
            binding.userRecycler.layoutManager = LinearLayoutManager(activity)
        }
    }

}