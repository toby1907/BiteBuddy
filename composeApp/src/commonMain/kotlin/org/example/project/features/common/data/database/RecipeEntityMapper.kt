package org.example.project.features.common.data.database

import org.example.project.features.common.domain.entities.RecipeItem
import orgexampleproject.Recipe

fun recipeEntityMapper(recipe: Recipe)  =
    org.example.project.features.common.domain.entities.RecipeItem(
        recipe.id,
        recipe.title,
        recipe.description,
        recipe.category,
        recipe.area,
        recipe.imageUrl,
        recipe.youtubeLink,
        recipe.ingredients,
        recipe.instructions,
        recipe.isFavorite == 1L,
        recipe.rating,
        recipe.duration ?: "20 Mins",
        recipe.difficulty ?: "Easy"
    )