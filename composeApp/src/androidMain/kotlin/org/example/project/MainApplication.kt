package org.example.project

import android.app.Application
import org.example.project.dbFactory.DatabaseFactory
import org.example.project.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class MainApplication : Application() {

private val androidModules = module{
single {
    DatabaseFactory(applicationContext)
}
}

    override fun onCreate() {
        super.onCreate()
    }

    fun setupKoin(){
        initKoin(additionalModules = listOf(androidModules)){
            androidContext(this@MainApplication)
        }

    }
}