package org.example.project.di

import org.example.project.datasource.ElectricVehicle
import org.example.project.datasource.GasVehicle
import org.example.project.domain.Vehicle
import org.example.project.ui.RoadTripModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

object VehicleQualifier {
    val GAS = named("GasVehicle")
    val ELECTRIC = named("ElectricVehicle")
}

expect val restaurantModule: Module

val datasourceModule = module {
    single(qualifier = VehicleQualifier.GAS){ GasVehicle() }.bind<Vehicle>()
    single(qualifier = VehicleQualifier.ELECTRIC){ ElectricVehicle() }.bind<Vehicle>()
}

val roadTripModule = module {
    includes(datasourceModule, restaurantModule)
    factory{
        RoadTripModel(
            get(VehicleQualifier.GAS),
            get(VehicleQualifier.ELECTRIC),
            get()
        )
    }
}


fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)

        modules(roadTripModule)
    }
}