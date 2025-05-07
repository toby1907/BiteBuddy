package org.example.project.features.feed.data.datasources

interface FeedLocalDataSource {
    suspend fun getRecipesList(): List<RecipeItem>
}