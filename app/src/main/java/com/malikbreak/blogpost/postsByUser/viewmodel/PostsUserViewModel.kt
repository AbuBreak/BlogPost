package com.malikbreak.blogpost.postsByUser.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malikbreak.blogpost.post.model.PostModelItem
import com.malikbreak.blogpost.postsByUser.api.UsersPostClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsUserViewModel:ViewModel() {

    var postsMutableLiveData = MutableLiveData<List<PostModelItem>>()

    fun getUsersPost(){
        UsersPostClient.userPostApi.getUser(2).enqueue(object :Callback<List<PostModelItem>>{
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
}