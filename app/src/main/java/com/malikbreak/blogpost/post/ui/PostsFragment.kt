package com.malikbreak.blogpost.post.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikbreak.blogpost.core.base.BaseFragment
import com.malikbreak.blogpost.databinding.FragmentPostsBinding
import com.malikbreak.blogpost.post.adapter.PostsAdapter
import com.malikbreak.blogpost.post.model.PostModelItem
import com.malikbreak.blogpost.post.viewmodel.PostViewModel

class PostsFragment : BaseFragment<FragmentPostsBinding>() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var adapter: PostsAdapter
    private  var posts: List<PostModelItem>? =null

    override fun getViewBinding(): FragmentPostsBinding =
        FragmentPostsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]

        
        postViewModel.getPosts()
        posts?.let { adapter.setPostList(it) }
        postViewModel.postsMutableLiveData.observe(viewLifecycleOwner){ it ->

            adapter = PostsAdapter(requireContext(), it)
            binding.postRecycler.adapter = adapter
            binding.postRecycler.layoutManager = LinearLayoutManager(activity)
        }
    }
}