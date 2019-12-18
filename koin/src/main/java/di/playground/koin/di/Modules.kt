package di.playground.koin.di

import di.playground.core.data.UserRepository
import di.playground.core.data.UserRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<UserRepository> { UserRepositoryImpl }
}