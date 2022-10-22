package com.malikbreak.blogpost.todo.model

data class TodoModelItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)