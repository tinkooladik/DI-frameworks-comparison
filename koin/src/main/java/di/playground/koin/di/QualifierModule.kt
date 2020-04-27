package di.playground.koin.di

import di.playground.core.data.FoodRepository
import di.playground.core.data.FoodRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module


val qualifierModule = module {
    single<FoodRepository>(qualifier = named("food")) { FoodRepositoryImpl() }
    single<FoodRepository>(qualifier = named("food1")) { FoodRepositoryImpl() }
}