package com.innovation.mygraduationproject.repository

import com.innovation.mygraduationproject.model.Post
import com.innovation.mygraduationproject.remote.ApiService

class PostRepositoryImpl(
    private val api: ApiService
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        return api.getPosts().map { dto ->
            Post(id = dto.id, title = dto.title, body = dto.body)
        }
    }

    override suspend fun getPost(id: Int): Post {
        val dto = api.getPost(id)
        return Post(id = dto.id, title = dto.title, body = dto.body)
    }
}
