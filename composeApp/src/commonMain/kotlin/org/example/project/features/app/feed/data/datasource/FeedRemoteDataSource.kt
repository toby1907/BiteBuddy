package org.example.project.features.app.feed.data.datasource

import org.example.project.features.app.common.domain.entities.RecipeItem

interface FeedRemoteDataSource {
    suspend fun getRecipesList(): List<RecipeItem>
}