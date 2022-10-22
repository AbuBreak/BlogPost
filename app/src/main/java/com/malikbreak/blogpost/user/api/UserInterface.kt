package com.malikbreak.blogpost.user.api

import com.malikbreak.blogpost.user.model.UserModelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserInterface {
    @GET("users")

    fun getUsers(): Call<List<UserModelItem>>
}