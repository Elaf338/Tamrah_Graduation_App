package com.innovation.mygraduationproject.usecase

import com.innovation.mygraduationproject.repository.PostRepository

class GetPostUseCase(private val repo: PostRepository) {
    suspend operator fun invoke(id: Int) = repo.getPost(id)
}