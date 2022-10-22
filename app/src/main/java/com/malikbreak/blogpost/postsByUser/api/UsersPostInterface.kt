package com.malikbreak.blogpost.postsByUser.api

import com.malikbreak.blogpost.post.model.PostModelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersPostInterface {
    @GET("posts")

    fun getUser(@Query("userId") userId: Int):Call<List<PostModelItem>>
}