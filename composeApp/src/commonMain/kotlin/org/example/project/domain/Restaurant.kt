package org.example.project.domain

interface Restaurant {
    fun eat(onEat: (String) -> Unit)
}