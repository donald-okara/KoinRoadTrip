package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.ui.RoadTripScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(RoadTripScreen())
    }
}