package org.example.project

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.example.project.di.initKoin
class MainApplication: Application() {

    private val androidModules = module {
      /*  single { DatabaseFactory(applicationContext) }
        single { MultiplatformSettingsFactory(applicationContext) }*/
    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        initKoin(additionalModules = listOf(androidModules)) {
            androidContext(applicationContext)
        }
    }
}