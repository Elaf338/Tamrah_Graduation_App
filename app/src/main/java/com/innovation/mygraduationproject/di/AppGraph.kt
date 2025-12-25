package com.innovation.mygraduationproject.di

import com.innovation.mygraduationproject.remote.ApiClient
import com.innovation.mygraduationproject.repository.PostRepository
import com.innovation.mygraduationproject.repository.PostRepositoryImpl
import com.innovation.mygraduationproject.usecase.GetPostUseCase
import com.innovation.mygraduationproject.usecase.GetPostsUseCase

object AppGraph {

    private val api by lazy { ApiClient.api }

    private val postRepo: PostRepository by lazy {
        PostRepositoryImpl(api)
    }

    val getPostsUseCase by lazy { GetPostsUseCase(postRepo) }
    val getPostUseCase by lazy { GetPostUseCase(postRepo) }
}