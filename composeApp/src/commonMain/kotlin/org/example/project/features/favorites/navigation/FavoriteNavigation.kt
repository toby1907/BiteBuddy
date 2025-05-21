package org.example.project.features.favorites.navigation
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.example.project.features.app.data.Screen

fun NavController.navigateToFavorites(navOptions: NavOptions? = null) {
    navigate(Screen.Favorites.route)
}

fun NavGraphBuilder.favoritesNavGraph(
    navigateToDetail: (Long) -> Unit,
    isUserLoggedIn: () -> Boolean,
) {

    composable(Screen.Favorites.route) {
        FavoritesRoute(
            navigateToDetail = navigateToDetail,
            isUserLoggedIn = isUserLoggedIn,
        )
    }

}