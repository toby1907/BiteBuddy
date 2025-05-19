package org.example.project.features.feed.ui

import org.example.project.features.common.domain.entities.RecipeItem

data class FeedUiState(
    val recipesList: List<org.example.project.features.common.domain.entities.RecipeItem>? = null,
    val recipesListIsLoading: Boolean = true,
    val recipesListError: String? = null,
)
