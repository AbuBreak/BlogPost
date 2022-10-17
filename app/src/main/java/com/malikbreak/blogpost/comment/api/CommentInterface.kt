package com.malikbreak.blogpost.comment.api

import com.malikbreak.blogpost.comment.model.CommentModelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentInterface {
    @GET("comments")

    fun getComments(@Query("postId") postId: Int): Call<List<CommentModelItem>>
}