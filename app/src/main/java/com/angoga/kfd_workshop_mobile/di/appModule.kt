package com.angoga.kfd_workshop_mobile.di

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.bind
import org.koin.dsl.module
import com.angoga.kfd_workshop_mobile.remote.service.HttpService
import com.angoga.kfd_workshop_mobile.remote.service.impl.HttpServiceImpl


val networkModule = module {
    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }
    }

    single { HttpServiceImpl(get()) } bind HttpService::class
}


val appModule = module {

} + networkModule
