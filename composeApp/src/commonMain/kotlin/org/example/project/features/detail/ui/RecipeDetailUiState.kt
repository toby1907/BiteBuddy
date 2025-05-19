package org.example.project.features.detail.ui

import org.example.project.features.common.domain.entities.RecipeItem


data class RecipeDetailUiState(
    val recipesDetail: RecipeItem? = null,
    val recipesDetailIsLoading: Boolean = true,
    val recipesDetailError: String? = null,
)