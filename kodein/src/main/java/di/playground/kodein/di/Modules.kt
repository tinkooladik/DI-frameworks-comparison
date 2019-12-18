package di.playground.kodein.di

import di.playground.core.data.UserRepository
import di.playground.core.data.UserRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

val dataModule = Kodein.Module("data") {
    bind<UserRepository>() with singleton { UserRepositoryImpl }
}