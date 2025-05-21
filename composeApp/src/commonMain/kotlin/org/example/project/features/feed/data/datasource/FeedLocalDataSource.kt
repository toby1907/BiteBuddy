package org.example.project.features.feed.data.datasource

import org.example.project.features.common.domain.entities.RecipeItem

interface FeedLocalDataSource {
    suspend fun getRecipesList(): List<org.example.project.features.common.domain.entities.RecipeItem>
    suspend fun saveRecipesList(recipes: List<org.example.project.features.common.domain.entities.RecipeItem>)
}