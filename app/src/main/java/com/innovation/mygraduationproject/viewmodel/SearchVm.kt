package com.innovation.mygraduationproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innovation.mygraduationproject.Language
import com.innovation.mygraduationproject.data.DateType
import com.innovation.mygraduationproject.data.DatesCatalog
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchDatesVm : ViewModel() {

    var state: UiState<List<DateType>> = UiState.Success(emptyList())
        private set

    private var job: Job? = null

    fun search(query: String, lang: Language) {
        job?.cancel()

        val q = query.trim()
        if (q.isBlank()) {
            state = UiState.Success(emptyList())
            return
        }

        job = viewModelScope.launch {
            state = UiState.Loading
            delay(700)

            try {
                val results = DatesCatalog.all.filter { d ->
                    val name = if (lang == Language.AR) d.nameAr else d.nameEn
                    val region = if (lang == Language.AR) d.regionAr else d.regionEn
                    val desc = if (lang == Language.AR) d.generalDescAr else d.generalDescEn

                    listOf(name, region, desc).any { it.contains(q, ignoreCase = true) }
                }

                state = UiState.Success(results)
            } catch (e: Exception) {
                state = UiState.Error("Failed to load results")
            }
        }
    }
}