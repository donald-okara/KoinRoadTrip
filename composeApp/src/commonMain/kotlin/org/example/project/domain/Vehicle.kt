package org.example.project.domain

interface Vehicle {
    fun start(onStart: (String) -> Unit)

    fun drive(onDrive: (String) -> Unit)

    fun stop(onStop: (String) -> Unit)
}