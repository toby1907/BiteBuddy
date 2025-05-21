package org.example.project.features.detail.data.datasource

import org.example.project.features.common.domain.entities.RecipeItem

interface RecipeDetailRemoteDataSource {

    suspend fun getRecipeDetail(id: Long): RecipeItem?

}