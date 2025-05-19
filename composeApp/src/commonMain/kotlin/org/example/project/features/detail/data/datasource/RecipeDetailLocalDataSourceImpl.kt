package org.example.project.features.detail.data.datasource

import org.example.project.features.common.data.database.daos.FavoriteRecipeDao
import org.example.project.features.common.data.database.daos.RecipeDao
import org.example.project.features.common.domain.entities.RecipeItem


class RecipeDetailLocalDataSourceImpl(
    private val recipeDao: RecipeDao,
    private val favoriteRecipeDao: FavoriteRecipeDao
): RecipeDetailLocalDataSource {

    override suspend fun getRecipeDetail(id: Long): RecipeItem? {
        return recipeDao.getRecipeById(id)
    }

    override suspend fun saveRecipe(recipe: RecipeItem) {
        recipeDao.insertRecipe(recipe)
    }

    override suspend fun addFavorite(recipeId: Long) {
        favoriteRecipeDao.addFavorite(recipeId)
    }

    override suspend fun removeFavorite(recipeId: Long) {
        favoriteRecipeDao.removeFavorite(recipeId)
    }

    override suspend fun isFavorite(recipeId: Long): Boolean {
        return favoriteRecipeDao.isFavorite(recipeId)
    }
}