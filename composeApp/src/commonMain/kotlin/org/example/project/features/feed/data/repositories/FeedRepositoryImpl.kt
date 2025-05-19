package org.example.project.features.feed.data.repositories

import org.example.project.features.common.domain.entities.RecipeItem
import org.example.project.features.app.feed.data.datasource.FeedLocalDataSource
import org.example.project.features.app.feed.data.datasource.FeedRemoteDataSource
import org.example.project.features.feed.domain.repositories.FeedRepository

class FeedRepositoryImpl(
    private val feedLocalDataSource: FeedLocalDataSource,
    private val feedRemoteDataSource: FeedRemoteDataSource,
): org.example.project.features.feed.domain.repositories.FeedRepository {

    override suspend fun getRecipesList(): Result<List<org.example.project.features.common.domain.entities.RecipeItem>> {
        return try {
            val recipeListCache = feedLocalDataSource.getRecipesList()
            val count = recipeListCache.count()
            return if (count > 0) {
                Result.success(recipeListCache)
            } else {
                val recipeListApiResponse = feedRemoteDataSource.getRecipesList()
                feedLocalDataSource.saveRecipesList(recipeListApiResponse)
                Result.success(recipeListApiResponse)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
