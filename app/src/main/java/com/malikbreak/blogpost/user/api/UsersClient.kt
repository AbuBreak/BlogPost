package com.malikbreak.blogpost.user.api

import com.malikbreak.blogpost.post.model.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsersClient {
    companion object{
        private val retrofit: Retrofit by lazy{
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val UsersApi:UserInterface by lazy{
            retrofit.create(UserInterface::class.java)
        }
    }
}