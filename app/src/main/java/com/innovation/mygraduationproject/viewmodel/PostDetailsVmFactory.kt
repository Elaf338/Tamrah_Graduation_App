package com.innovation.mygraduationproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.innovation.mygraduationproject.usecase.GetPostUseCase

class PostDetailsVmFactory(
    private val getPostUseCase: GetPostUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostDetailsVm::class.java)) {
            return PostDetailsVm(getPostUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
