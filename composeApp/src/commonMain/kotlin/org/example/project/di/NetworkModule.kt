package org.example.project.di

import io.ktor.client.HttpClient
import org.example.project.features.app.common.data.api.httpClient
import org.koin.dsl.module

fun networkModule()  = module {

    single<HttpClient> {
        httpClient
    }
}