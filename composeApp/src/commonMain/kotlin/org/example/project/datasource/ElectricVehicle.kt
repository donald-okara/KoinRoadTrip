package org.example.project.datasource

import org.example.project.domain.Vehicle

class ElectricVehicle: Vehicle {
    override fun start(onStart: (String) -> Unit) {
        onStart("\uD83C\uDFCE\uFE0F PSSS or whatever teslas sound like")
    }

    override fun drive(onDrive: (String) -> Unit) {
        onDrive("\uD83C\uDFCE\uFE0F Listening to Diplo")
    }

    override fun stop(onStop: (String) -> Unit) {
        onStop("\uD83C\uDFCE\uFE0F Stop")
    }
}