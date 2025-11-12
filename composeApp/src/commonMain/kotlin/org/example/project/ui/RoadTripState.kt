package org.example.project.ui

data class RoadTripState(
    val isUpdating: Boolean = false,
    val checkPoints: List<String> = emptyList()
)
