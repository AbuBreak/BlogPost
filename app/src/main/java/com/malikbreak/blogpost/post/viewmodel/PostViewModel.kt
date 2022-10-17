package com.malikbreak.blogpost.post.viewmodel

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malikbreak.blogpost.post.api.PostsClient
import com.malikbreak.blogpost.post.model.PostModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    var postsMutableLiveData = MutableLiveData<List<PostModelItem>>()


    fun getPosts() {
        PostsClient.PostsApi.getPosts().enqueue(object : Callback<List<PostModelItem>> {
            override fun onResponse(
                call: Call<List<PostModelItem>>,
                response: Response<List<PostModelItem>>
            ) {
                postsMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<PostModelItem>>, t: Throwable) {
                d("AAA", "onFailure")
            }
        })
    }


}