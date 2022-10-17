package com.malikbreak.blogpost.comment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malikbreak.blogpost.comment.api.CommentsClient
import com.malikbreak.blogpost.comment.model.CommentModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentViewModel : ViewModel() {

    var commentsMutableLiveData = MutableLiveData<List<CommentModelItem>>()

    fun getComments() {
        CommentsClient.CommentsApi.getComments(5).enqueue(object : Callback<List<CommentModelItem>> {
            override fun onResponse(
                call: Call<List<CommentModelItem>>,
                response: Response<List<CommentModelItem>>
            ) {
                commentsMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<CommentModelItem>>, t: Throwable) {
                return t.printStackTrace()
            }
        })
    }

}