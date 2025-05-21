package org.example.project.features.detail.data.datasource

import org.example.project.features.common.data.api.BASE_URL
import org.example.project.features.common.domain.entities.RecipeItem
import org.example.project.features.common.models.RecipeListApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.example.project.features.common.models.toRecipe

class RecipeDetailRemoteDataSourceImpl(
    private val httpClient: HttpClient
): RecipeDetailRemoteDataSource {

    override suspend fun getRecipeDetail(id: Long): RecipeItem? {
        val httpResponse = httpClient.get("${BASE_URL}lookup.php?i=$id")
        return httpResponse.body<RecipeListApiResponse>().meals.firstOrNull()?.toRecipe()
    }

}