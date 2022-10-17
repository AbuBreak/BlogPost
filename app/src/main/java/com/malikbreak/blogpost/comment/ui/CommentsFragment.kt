package com.malikbreak.blogpost.comment.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikbreak.blogpost.core.base.BaseFragment
import com.malikbreak.blogpost.databinding.FragmentCommentsBinding
import com.malikbreak.blogpost.comment.adapter.CommentsAdapter
import com.malikbreak.blogpost.comment.model.CommentModelItem
import com.malikbreak.blogpost.comment.viewmodel.CommentViewModel

class CommentsFragment : BaseFragment<FragmentCommentsBinding>() {

    private lateinit var commentViewModel:CommentViewModel
    private lateinit var adapter: CommentsAdapter
    private var comments: List<CommentModelItem>? = null

    override fun getViewBinding(): FragmentCommentsBinding =
        FragmentCommentsBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        commentViewModel = ViewModelProvider(this)[CommentViewModel::class.java]

        commentViewModel.getComments()
        comments?.let { adapter.setCommentList(it) }

        commentViewModel.commentsMutableLiveData.observe(viewLifecycleOwner){
            adapter = CommentsAdapter(requireContext(),it)
            binding.commentRecycler.adapter = adapter
            binding.commentRecycler.layoutManager = LinearLayoutManager(activity)
        }

    }
}
