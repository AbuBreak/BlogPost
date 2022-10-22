package com.malikbreak.blogpost.postsByUser.api

import com.malikbreak.blogpost.post.model.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsersPostClient {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val userPostApi: UsersPostInterface by lazy {
            retrofit.create(UsersPostInterface::class.java)
        }
    }
}