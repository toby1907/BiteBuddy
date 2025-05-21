package org.example.project.features.feed.domain.repositories

import org.example.project.features.common.domain.entities.RecipeItem

interface FeedRepository {

    suspend fun getRecipesList(): Result<List<org.example.project.features.common.domain.entities.RecipeItem>>
}