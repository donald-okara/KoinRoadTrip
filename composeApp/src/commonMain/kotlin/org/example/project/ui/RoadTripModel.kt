package org.example.project.ui

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.datasource.VehicleImpl

class RoadTripModel(): ScreenModel {
    private val vehicle = VehicleImpl()

    private val _uiState = MutableStateFlow(RoadTripState())
    val uiState = _uiState.asStateFlow()

    fun start(){
        // Reset on each start
        screenModelScope.launch{
            _uiState.update {
                it.copy(
                    isUpdating = true,
                    checkPoints = emptyList()
                )
            }

            vehicle.start { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }

            delay(1000)

            vehicle.drive { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }

            delay(1000)

            vehicle.stop { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }

            _uiState.update {
                it.copy(
                    checkPoints = it.checkPoints.plus("🏁: Destination arrived"),
                    isUpdating = false
                )
            }
        }
    }
}