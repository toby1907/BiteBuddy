package org.example.project.features.app.feed.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.example.project.features.app.common.data.api.BASE_URL
import org.example.project.features.app.common.domain.entities.RecipeItem
import org.example.project.features.app.common.models.RecipeListApiResponse
import org.example.project.features.app.common.models.toRecipe

class FeedRemoteDataSourceImpl(
    private val httpClient: HttpClient
): FeedRemoteDataSource {
    override suspend fun getRecipesList(): List<RecipeItem> {
        val httpResponse = httpClient.get("${BASE_URL}search.php?f=b")
        val recipeListApiResponse = httpResponse.body<RecipeListApiResponse>()
        return recipeListApiResponse.meals.mapNotNull {
            it.toRecipe()
        }
    }
}