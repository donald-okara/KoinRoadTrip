package org.example.project.datasource

import org.example.project.domain.Vehicle

class VehicleImpl: Vehicle {
    override fun start(onStart: (String) -> Unit) {
        onStart("🚗 Vroom vroom")
    }
}