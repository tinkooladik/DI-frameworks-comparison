package di.playground.koin.di

import di.playground.core.data.*
import org.koin.dsl.bind
import org.koin.dsl.module


/**
 * Multi-binding
 */

val multibindingModule = module {

    single { UserSettings() } bind Settings::class
    factory { VolumeSettings() } bind Settings::class

    single { ThemeSettings() } bind Settings::class
    factory { PrivacySettings() } bind Settings::class

    /*
    Currently, multi-binding is not implemented. It was
     */
}