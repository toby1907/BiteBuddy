package org.example.project.di

import org.example.project.features.app.feed.data.datasource.FeedLocalDataSource
import org.example.project.features.app.feed.data.datasource.FeedLocalDataSourceImpl
import org.example.project.features.app.feed.data.datasource.FeedRemoteDataSource
import org.example.project.features.app.feed.data.datasource.FeedRemoteDataSourceImpl
import org.example.project.features.app.feed.data.repositories.FeedRepositoryImpl
import org.example.project.features.app.feed.domain.repositories.FeedRepository
import org.koin.dsl.module

fun dataModule()  = module {
   single<FeedLocalDataSource> { FeedLocalDataSourceImpl(get()) }
   single<FeedRemoteDataSource> { FeedRemoteDataSourceImpl(get()) }
   single<FeedRepository> { FeedRepositoryImpl(get(), get()) }


   /* single<AppPreferences> { AppPreferencesImpl(get()) }
  single<RecipeDetailLocalDataSource> { RecipeDetailLocalDataSourceImpl(get(), get()) }
   single<RecipeDetailRemoteDataSource> { RecipeDetailRemoteDataSourceImpl(get()) }

   single<FavoriteRecipeLocalDataSource> { FavoriteRecipeLocalDataSourceImpl(get()) }
       single<RecipeDetailRepository> { RecipeDetailRepositoryImpl(get(), get()) }
   single<SearchRecipeLocalDataSource> { SearchRecipeLocalDataSourceImpl(get()) }
   single<SearchRecipeRepository> { SearchRecipeRepositoryImpl(get()) }
    single<FavoriteRecipeRepository> { FavoriteRecipeRepositoryImpl(get()) }

  */
}