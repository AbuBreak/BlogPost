package com.malikbreak.blogpost.todo.api

import com.malikbreak.blogpost.todo.model.TodoModelItem
import retrofit2.Call
import retrofit2.http.GET

interface TodoInterface {
    @GET("todos")

    fun getTodos() : Call<List<TodoModelItem>>
}