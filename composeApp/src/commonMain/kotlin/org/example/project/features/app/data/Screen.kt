package org.example.project.features.app.data

import bitebuddy.composeapp.generated.resources.Res
import bitebuddy.composeapp.generated.resources.detail
import bitebuddy.composeapp.generated.resources.favorites
import bitebuddy.composeapp.generated.resources.home
import bitebuddy.composeapp.generated.resources.profile
import bitebuddy.composeapp.generated.resources.search
import bitebuddy.composeapp.generated.resources.tabs
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class Screen(
    val route: String,
    val resourceId: StringResource,
    val selectedIcon: DrawableResource? = null,
    val unselectedIcon: DrawableResource? = null,
) {

    data object Search : Screen("search", Res.string.search)
    data object Tabs : Screen("tabs", Res.string.tabs)
    data object Detail : Screen("detail?$RECIPE_ID_ARG={$RECIPE_ID_ARG}", Res.string.detail)

    data object Home : Screen("home",
        Res.string.home,
        selectedIcon = Res.drawable.home_selected,
        unselectedIcon = Res.drawable.home_unselected
    )

    data object Favorites : Screen("favorites",
        Res.string.favorites,
        selectedIcon = Res.drawable.bookmark_selected,
        unselectedIcon = Res.drawable.bookmark_unselected
    )

    data object Profile : Screen("profile",
        Res.string.profile,
        selectedIcon = Res.drawable.profile_selected,
        unselectedIcon = Res.drawable.profile_unselected
    )
}