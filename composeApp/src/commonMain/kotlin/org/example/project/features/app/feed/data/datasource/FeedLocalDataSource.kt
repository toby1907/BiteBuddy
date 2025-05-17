package org.example.project.features.app.feed.data.datasource

import org.example.project.features.app.common.domain.entities.RecipeItem

interface FeedLocalDataSource {
    suspend fun getRecipesList(): List<RecipeItem>
    suspend fun saveRecipesList(recipes: List<RecipeItem>)
}