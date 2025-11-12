package org.example.project.di

import org.example.project.datasource.VehicleImpl
import org.example.project.domain.Vehicle
import org.example.project.ui.RoadTripModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

val datasourceModule = module {
    singleOf(::VehicleImpl).bind<Vehicle>()
}


val roadTripModule = module {
    includes(datasourceModule)
    factoryOf(::RoadTripModel)
}


fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)

        modules(roadTripModule)
    }
}