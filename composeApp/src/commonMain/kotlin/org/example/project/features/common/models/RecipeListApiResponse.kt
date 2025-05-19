package org.example.project.features.common.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeListApiResponse(
    @SerialName("meals")
    val meals: List<RecipeApiItem>
)