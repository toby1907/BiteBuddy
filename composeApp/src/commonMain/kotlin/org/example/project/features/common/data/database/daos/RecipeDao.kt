package org.example.project.features.common.data.database.daos

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOneOrNull
import org.example.project.features.common.data.database.DbHelper
import org.example.project.features.app.common.data.database.recipeEntityMapper
import org.example.project.features.common.domain.entities.RecipeItem

class RecipeDao(
    private val dbHelper: org.example.project.features.common.data.database.DbHelper
) {

    suspend fun insertRecipe(recipeItem: org.example.project.features.common.domain.entities.RecipeItem) {
        dbHelper.withDatabase { database ->
            database.recipeEntityQueries.insertRecipe(
                recipeItem.id,
                recipeItem.title,
                recipeItem.description,
                recipeItem.category,
                recipeItem.area,
                recipeItem.imageUrl,
                recipeItem.youtubeLink,
                recipeItem.ingredients,
                recipeItem.instructions,
                if (recipeItem.isFavorite) 1 else 0,
                recipeItem.rating,
                recipeItem.duration,
                recipeItem.difficulty
            )
        }
    }

    suspend fun updateRecipe(recipeItem: org.example.project.features.common.domain.entities.RecipeItem) {
        dbHelper.withDatabase { database ->
            database.recipeEntityQueries.updateRecipe(
                recipeItem.title,
                recipeItem.description,
                recipeItem.category,
                recipeItem.area,
                recipeItem.imageUrl,
                recipeItem.youtubeLink,
                recipeItem.ingredients,
                recipeItem.instructions,
                if (recipeItem.isFavorite) 1 else 0,
                recipeItem.rating,
                recipeItem.duration,
                recipeItem.difficulty,
                recipeItem.id
            )
        }
    }

    suspend fun insertRecipesBulk(recipes: List<org.example.project.features.common.domain.entities.RecipeItem>) {
        dbHelper.withDatabase { database ->
            recipes.forEach { recipeItem ->
                database.recipeEntityQueries.insertRecipe(
                    recipeItem.id,
                    recipeItem.title,
                    recipeItem.description,
                    recipeItem.category,
                    recipeItem.area,
                    recipeItem.imageUrl,
                    recipeItem.youtubeLink,
                    recipeItem.ingredients,
                    recipeItem.instructions,
                    if (recipeItem.isFavorite) 1 else 0,
                    recipeItem.rating,
                    recipeItem.duration,
                    recipeItem.difficulty
                )
            }
        }
    }

    suspend fun upsertRecipesBulk(recipes: List<org.example.project.features.common.domain.entities.RecipeItem>) {
        dbHelper.withDatabase { database ->
            recipes.forEach { recipeItem ->
                database.recipeEntityQueries.upsertRecipe(
                    recipeItem.title,
                    recipeItem.description,
                    recipeItem.category,
                    recipeItem.area,
                    recipeItem.imageUrl,
                    recipeItem.youtubeLink,
                    recipeItem.ingredients,
                    recipeItem.instructions,
                    if (recipeItem.isFavorite) 1 else 0,
                    recipeItem.rating,
                    recipeItem.duration,
                    recipeItem.difficulty,
                    recipeItem.id,
                )
            }
        }
    }

    suspend fun getAllRecipes(): List<org.example.project.features.common.domain.entities.RecipeItem> {

        return dbHelper.withDatabase { database ->
            database.recipeEntityQueries.selectAllRecipes().awaitAsList().map {
                recipeEntityMapper(it)
            }
        }

    }

    suspend fun getRecipeById(id: Long): org.example.project.features.common.domain.entities.RecipeItem? {

        return dbHelper.withDatabase { database ->
            database.recipeEntityQueries.selectRecipeById(id).awaitAsOneOrNull()?.let {
                recipeEntityMapper(it)
            }
        }

    }

    suspend fun deleteRecipeById(id: Long) {
        dbHelper.withDatabase { database ->
            database.recipeEntityQueries.detelteRecipeById(id)
        }
    }


    suspend fun searchRecipesByText(text: String): List<org.example.project.features.common.domain.entities.RecipeItem> {
        return dbHelper.withDatabase { database ->
            database.recipeEntityQueries.searchRecipeByText(text).awaitAsList().map {
                recipeEntityMapper(it)
            }
        }
    }

}