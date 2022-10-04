package com.malikbreak.blogpost.post.api


import com.malikbreak.blogpost.post.model.CommentModelItem
import com.malikbreak.blogpost.post.model.PostModelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostInterface {
    @GET("posts")
    fun getPosts(): Call<List<PostModelItem>>

    @GET("comments")
    fun getComments(

    ): Call<List<CommentModelItem>>
}