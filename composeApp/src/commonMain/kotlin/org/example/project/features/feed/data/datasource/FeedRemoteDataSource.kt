package org.example.project.features.feed.data.datasource

import org.example.project.features.common.domain.entities.RecipeItem

interface FeedRemoteDataSource {
    suspend fun getRecipesList(): List<org.example.project.features.common.domain.entities.RecipeItem>
}