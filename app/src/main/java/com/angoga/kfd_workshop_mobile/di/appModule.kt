package com.angoga.kfd_workshop_mobile.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.angoga.kfd_workshop_mobile.database.AppDatabase
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.bind
import org.koin.dsl.module
import com.angoga.kfd_workshop_mobile.remote.service.HttpService
import com.angoga.kfd_workshop_mobile.remote.service.impl.HttpServiceImpl
import com.angoga.kfd_workshop_mobile.ui.screens.create_news.PublicationRepository
import com.angoga.kfd_workshop_mobile.ui.screens.create_news.PublicationViewModel
import com.angoga.kfd_workshop_mobile.ui.screens.login.LoginViewModel
import com.angoga.kfd_workshop_mobile.ui.screens.register.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


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

    single { HttpServiceImpl(get(), get()) } bind HttpService::class
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegistrationViewModel(get()) }
    viewModel { PublicationViewModel(get(), get()) }
}

val repositoryModule = module {
    single { PublicationRepository(get(), get()) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "KFD.db")
            .allowMainThreadQueries()
            .build()
    }
}


val appModule = module {

} + networkModule + viewModelModule + repositoryModule + databaseModule
