package com.innovation.mygraduationproject.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innovation.mygraduationproject.model.Post
import com.innovation.mygraduationproject.usecase.GetPostsUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomePostsVm(
    private val getPosts: GetPostsUseCase
) : ViewModel() {

    var state by mutableStateOf<UiState<List<Post>>>(UiState.Loading)
        private set

    init {
        load()
    }

    fun load() {
        state = UiState.Loading
        viewModelScope.launch {
            state = try {
                val posts = getPosts().take(10)
                UiState.Success(posts)
            } catch (e: IOException) {
                Log.e("API", "IO error", e)
                UiState.Error("No internet / timeout: ${e.message}")
            } catch (e: HttpException) {
                Log.e("API", "HTTP error", e)
                UiState.Error("HTTP ${e.code()}: ${e.message()}")
            } catch (e: Exception) {
                Log.e("API", "Unknown error", e)
                UiState.Error("Unknown: ${e.message}")
            }
        }
    }
}