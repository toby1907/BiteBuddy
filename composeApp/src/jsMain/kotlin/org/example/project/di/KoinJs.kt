package org.example.project.di
import org.koin.dsl.module

val jsModules = module {
   /* single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }*/
}

fun initKoinJs() = initKoin(additionalModules = listOf(jsModules))