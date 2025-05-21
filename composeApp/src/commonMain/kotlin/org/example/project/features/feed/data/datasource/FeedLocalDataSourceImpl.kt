package org.example.project.features.feed.data.datasource

import org.example.project.features.app.common.data.database.daos.RecipeDao
import org.example.project.features.common.domain.entities.RecipeItem

class FeedLocalDataSourceImpl(
    private val recipeDao: RecipeDao
): FeedLocalDataSource {
    override suspend fun getRecipesList(): List<org.example.project.features.common.domain.entities.RecipeItem> {
        return recipeDao.getAllRecipes()
    }

    override suspend fun saveRecipesList(recipes: List<org.example.project.features.common.domain.entities.RecipeItem>) {
        recipeDao.insertRecipesBulk(recipes)
    }
}