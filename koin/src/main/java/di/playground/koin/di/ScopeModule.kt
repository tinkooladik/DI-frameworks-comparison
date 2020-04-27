package di.playground.koin.di

import di.playground.core.data.AnimalRepository
import di.playground.core.data.AnimalRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module


/**
 * Scopes
 */

object TestTypeQualifier

val scopeModule = module {
    /*
    By default in Koin, we have 3 kind of scopes:
       - single definition, create an object that persistent with the entire container lifetime (can't be dropped).
       - factory definition, create a new object each time. Short live. No persistence in the container (can't be shared).
       - scoped definition, create an object that persistent tied to the associated scope lifetime.

    A scope require a qualifier to help name it. It can be either a String Qualifier, either a Type Qualifier
     */

    /* String Qualifier */
    scope(named("StringQualifierScope")) {
        scoped<AnimalRepository> { AnimalRepositoryImpl() }
    }

    /* TypeQualifier */
    scope(named<TestTypeQualifier>()) {
        scoped<AnimalRepository> { AnimalRepositoryImpl() }
    }
}