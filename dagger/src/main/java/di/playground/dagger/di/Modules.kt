package di.playground.dagger.di

import dagger.Module
import dagger.Provides
import di.playground.core.data.UserRepository
import di.playground.core.data.UserRepositoryImpl
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository = UserRepositoryImpl
}