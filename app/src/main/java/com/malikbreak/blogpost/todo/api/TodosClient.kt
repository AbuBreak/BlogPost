package com.malikbreak.blogpost.todo.api

import com.malikbreak.blogpost.post.model.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodosClient {

    companion object{
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val TodoApi: TodoInterface by lazy {
            retrofit.create(TodoInterface::class.java)
        }
    }
}