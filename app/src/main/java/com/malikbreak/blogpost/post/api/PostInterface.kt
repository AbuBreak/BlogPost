package com.malikbreak.blogpost.post.api

import com.malikbreak.blogpost.post.model.PostModelItem
import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPosts(): Call<List<PostModelItem>>
}