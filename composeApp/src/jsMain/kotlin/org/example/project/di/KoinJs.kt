package org.example.project.di

val jsModules = module {
    single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }
}

fun initKoinJs() = initKoin(additionalModules = listOf(jsModules))