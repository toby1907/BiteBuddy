package org.example.project

import org.example.project.di.initKoin
import org.koin.dsl.module
import org.example.project.dbFactory.DatabaseFactory


val iosModules = module {
  single { DatabaseFactory()}
  /*  single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }*/
}

fun initKoinIOS() = initKoin(additionalModules = listOf(iosModules))