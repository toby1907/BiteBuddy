package org.example.project.di

import org.example.project.dbFactory.DatabaseFactory
import org.koin.dsl.module

val jvmModules = module {
    single {
        DatabaseFactory()
    }
}

fun initKoinJVM() = initKoin(additionalModules = listOf(jvmModules))