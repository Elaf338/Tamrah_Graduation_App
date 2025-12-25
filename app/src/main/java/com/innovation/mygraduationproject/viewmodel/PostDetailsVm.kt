package com.innovation.mygraduationproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innovation.mygraduationproject.model.Post
import com.innovation.mygraduationproject.usecase.GetPostUseCase
import kotlinx.coroutines.launch

class PostDetailsVm(
    private val getPost: GetPostUseCase
) : ViewModel() {

    var state by mutableStateOf<UiState<Post>>(UiState.Loading)
        private set

    fun load(postId: Int) {
        state = UiState.Loading
        viewModelScope.launch {
            try {
                state = UiState.Success(getPost(postId))
            } catch (e: Exception) {
                state = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}