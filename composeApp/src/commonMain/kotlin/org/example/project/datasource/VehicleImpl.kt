package org.example.project.datasource

import org.example.project.domain.Vehicle

class VehicleImpl: Vehicle {
    override fun start(onStart: (String) -> Unit) {
        onStart("🚗 Vroom vroom")
    }

    override fun drive(onDrive: (String) -> Unit) {
        onDrive("🚗 Listening to a podcast maybe")
    }

    override fun stop(onStop: (String) -> Unit) {
        onStop("🚗 Scrrrt")
    }


}