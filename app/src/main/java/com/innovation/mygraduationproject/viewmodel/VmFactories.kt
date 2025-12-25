package com.innovation.mygraduationproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.innovation.mygraduationproject.usecase.GetPostsUseCase

class HomePostsVmFactory(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomePostsVm::class.java)) {
            return HomePostsVm(getPostsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
