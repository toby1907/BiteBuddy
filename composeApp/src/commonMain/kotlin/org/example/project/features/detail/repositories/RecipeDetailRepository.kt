package org.example.project.features.detail.repositories

import org.example.project.features.common.domain.entities.RecipeItem

interface RecipeDetailRepository {

    suspend fun getRecipesDetail(id: Long): Result<RecipeItem>
    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)

}