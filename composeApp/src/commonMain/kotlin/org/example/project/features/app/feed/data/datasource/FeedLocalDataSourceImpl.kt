package org.example.project.features.app.feed.data.datasource

import org.example.project.features.app.common.data.database.daos.RecipeDao
import org.example.project.features.app.common.domain.entities.RecipeItem

class FeedLocalDataSourceImpl(
    private val recipeDao: RecipeDao
): FeedLocalDataSource {
    override suspend fun getRecipesList(): List<RecipeItem> {
        return recipeDao.getAllRecipes()
    }

    override suspend fun saveRecipesList(recipes: List<RecipeItem>) {
        recipeDao.insertRecipesBulk(recipes)
    }
}