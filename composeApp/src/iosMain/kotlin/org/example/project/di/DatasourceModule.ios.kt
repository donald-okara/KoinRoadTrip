package org.example.project.di

import org.example.project.datasource.Kempinski
import org.example.project.domain.Restaurant
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val restaurantModule: Module
    get() = module{
        singleOf(::Kempinski).bind<Restaurant>()
    }