package com.malikbreak.blogpost.post.api

import com.malikbreak.blogpost.post.model.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsClient {

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: PostInterface by lazy {
            retrofit.create(PostInterface::class.java)
        }
    }
}