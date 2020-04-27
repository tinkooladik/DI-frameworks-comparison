package di.playground.koin.di

import di.playground.core.data.UserRepository
import di.playground.core.data.UserRepositoryImpl
import di.playground.koin.ui.MainViewModel
import org.koin.dsl.module

val dataModule = module {

    /* single definition, create an object that persistent with
    the entire container lifetime (can't be dropped). */
    single<UserRepository> { UserRepositoryImpl }

    /* factory definition, create a new object each time.
    Short live. No persistence in the container (can't be shared). */
    factory { MainViewModel(get()) }
}