package org.example.project.features.favorites.ui

import org.example.project.features.common.domain.entities.RecipeItem

data class FavoritesScreenUiState(
    val itemsList: List<RecipeItem>? = null,
    val itemsListIsLoading: Boolean = true,
    val itemsListError: String? = null,
)