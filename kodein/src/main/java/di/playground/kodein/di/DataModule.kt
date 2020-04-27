package di.playground.kodein.di

import di.playground.core.data.UserRepository
import di.playground.core.data.UserRepositoryImpl
import di.playground.kodein.ui.MainViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val dataModule = Kodein.Module("data") {

    bind<UserRepository>() with singleton { UserRepositoryImpl }

    /* Creates a factory: each time an instance is needed, the function {} will be called.
     * instance() is a UserRepository parameter for constructor injection */
    bind() from provider { MainViewModel(instance()) }
}
