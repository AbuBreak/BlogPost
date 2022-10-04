package com.malikbreak.blogpost.post.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malikbreak.blogpost.post.api.PostsClient
import com.malikbreak.blogpost.post.model.CommentModelItem
import com.malikbreak.blogpost.post.model.PostModel
import com.malikbreak.blogpost.post.model.PostModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    var postsMutableLiveData = MutableLiveData<List<PostModelItem>> ()
    var commentsMutableLiveData = MutableLiveData<List<CommentModelItem>>()

    fun getPosts(){
        PostsClient.api.getPosts().enqueue(object :Callback<List<PostModelItem>> {
            override fun onResponse(
                call: Call<List<PostModelItem>>,
                response: Response<List<PostModelItem>>
            ) {
                postsMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<PostModelItem>>, t: Throwable) {
                return t.printStackTrace()
            }
        })
    }

    fun getComments(){
        PostsClient.api.getComments().enqueue(object :Callback<List<CommentModelItem>>{
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