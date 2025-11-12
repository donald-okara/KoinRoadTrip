package org.example.project.domain

interface Vehicle {
    fun start(onStart: (String) -> Unit)
}