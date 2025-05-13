package org.example.project.di

import org.koin.dsl.module

val jvmModules = module {
  /*  single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }*/
}

fun initKoinJvm() = initKoin(additionalModules = listOf(jvmModules))