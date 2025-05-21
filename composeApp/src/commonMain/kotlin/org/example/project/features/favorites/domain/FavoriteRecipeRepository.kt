package org.example.project.features.favorites.domain

import org.example.project.features.common.domain.entities.RecipeItem

interface FavoriteRecipeRepository {
    suspend fun getAllFavoriteRecipes(): Result<List<RecipeItem>>
    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)
}