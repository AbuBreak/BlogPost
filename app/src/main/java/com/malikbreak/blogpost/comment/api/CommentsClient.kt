package com.malikbreak.blogpost.comment.api

import com.malikbreak.blogpost.post.model.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommentsClient {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val CommentsApi: CommentInterface by lazy {
            retrofit.create(CommentInterface::class.java)
        }
    }
}