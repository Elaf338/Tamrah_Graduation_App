package com.innovation.mygraduationproject.usecase

import com.innovation.mygraduationproject.repository.PostRepository

class GetPostsUseCase(private val repo: PostRepository) {
    suspend operator fun invoke() = repo.getPosts()
}