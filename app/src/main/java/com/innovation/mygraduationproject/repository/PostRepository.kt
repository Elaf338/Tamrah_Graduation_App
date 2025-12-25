package com.innovation.mygraduationproject.repository

import com.innovation.mygraduationproject.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Int): Post
}