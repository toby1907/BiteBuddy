package org.example.project.features.app.feed.domain.repositories

import org.example.project.features.app.common.domain.entities.RecipeItem

interface FeedRepository {

    suspend fun getRecipesList(): Result<List<RecipeItem>>
}