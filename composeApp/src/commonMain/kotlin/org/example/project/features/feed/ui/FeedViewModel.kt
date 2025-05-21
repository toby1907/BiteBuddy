package org.example.project.features.feed.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.example.project.features.feed.domain.repositories.FeedRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FeedViewModel(
    private val feedRepository: org.example.project.features.feed.domain.repositories.FeedRepository
) : ViewModel() {

    private var _feedUiState = MutableStateFlow(org.example.project.features.feed.ui.FeedUiState())
    val feedUiState = _feedUiState.asStateFlow()

    init {
        viewModelScope.launch {
            getRecipesList()
        }
    }

    private suspend fun getRecipesList() {
        val recipesList = feedRepository.getRecipesList()
        if (recipesList.isSuccess) {
            _feedUiState.value = _feedUiState.value.copy(
                recipesList = recipesList.getOrDefault(emptyList()),
                recipesListIsLoading = false
            )
        } else {
            _feedUiState.update {
                it.copy(
                    recipesListError = recipesList.exceptionOrNull()?.message,
                    recipesListIsLoading = false
                )
            }
        }
    }

}