package com.malikbreak.blogpost.post.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikbreak.blogpost.core.base.BaseFragment
import com.malikbreak.blogpost.databinding.FragmentCommentsBinding
import com.malikbreak.blogpost.post.model.CommentModelItem


class CommentsFragment : BaseFragment<FragmentCommentsBinding>() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var adapter: CommentsAdapter
    private var comments: List<CommentModelItem>? = null

    override fun getViewBinding(): FragmentCommentsBinding =
        FragmentCommentsBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]

        postViewModel.getComments()

        adapter = comments?.let { CommentsAdapter(requireContext(), it) }!!

        binding.commentRecycler.adapter = adapter
        binding.commentRecycler.layoutManager = LinearLayoutManager(activity)

        postViewModel.commentsMutableLiveData.observe(viewLifecycleOwner) {
            adapter.setCommentList(comments!!)
        }
    }
}
