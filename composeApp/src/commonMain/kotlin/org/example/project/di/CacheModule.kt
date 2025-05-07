package org.example.project.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.example.project.features.common.data.database.DbHelper
import org.example.project.features.common.data.database.daos.RecipeDao
import org.koin.dsl.module


fun cacheModule() = module {

    single { Dispatchers.Default }
    single { CoroutineScope(get()) }

single { DbHelper(get()) }
single { RecipeDao(get()) }

}