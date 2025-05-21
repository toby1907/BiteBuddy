package org.example.project.features.detail.data.datasource

import org.example.project.features.common.domain.entities.RecipeItem

interface RecipeDetailLocalDataSource {

    suspend fun getRecipeDetail(id: Long): RecipeItem?
    suspend fun saveRecipe(recipe: RecipeItem)
    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)
    suspend fun isFavorite(recipeId: Long): Boolean

}