package di.playground.koin.di

import di.playground.core.data.UserRepository
import di.playground.core.data.UserRepositoryImpl
import di.playground.koin.ui.MainViewModel
import org.koin.dsl.module

val dataModule = module {
    single<UserRepository> { UserRepositoryImpl }
//    viewModel { MainViewModel(get()) }
    single { MainViewModel(get()) }
}