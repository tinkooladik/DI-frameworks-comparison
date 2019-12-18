package di.playground.dagger_android.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import di.playground.core.data.UserRepository
import di.playground.core.data.UserRepositoryImpl
import di.playground.dagger_android.MainActivity
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun provideUserRepository(): UserRepository = UserRepositoryImpl
    }
}

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun homeInjector(): MainActivity
}