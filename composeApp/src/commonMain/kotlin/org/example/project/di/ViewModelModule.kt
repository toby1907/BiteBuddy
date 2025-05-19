package org.example.project.di

import org.example.project.features.app.feed.ui.FeedViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

fun viewModelModule()  = module {
  viewModel {
    FeedViewModel(get())
  }
  /*

    viewModel {
        RecipeDetailViewModel(get())
    }

    viewModel {
        FavoritesScreenViewModel(get())
    }

    viewModel {
        ProfileViewModel()
    }

    viewModel {
        LoginViewModel()
    }
    viewModel {
        SearchViewModel(get())
    }*/

}