package com.malikbreak.blogpost.post.model

data class CommentModelItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)