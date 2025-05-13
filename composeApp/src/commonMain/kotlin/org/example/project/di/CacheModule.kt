package org.example.project.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

fun cacheModule()  = module {

    single<CoroutineContext> { Dispatchers.Default }
    single { CoroutineScope(get()) }

   /* single { DbHelper(get()) }
    single { RecipeDao(get()) }
    single { FavoriteRecipeDao(get()) }*/
}