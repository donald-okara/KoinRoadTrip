package org.example.project.ui

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.domain.Restaurant
import org.example.project.domain.Vehicle

class RoadTripModel(
    private val gasVehicle: Vehicle,
    private val electricVehicle: Vehicle,
    private val restaurant: Restaurant
): ScreenModel {
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

            gasVehicle.start { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }
            electricVehicle.start {
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(it))
                }

            }

            delay(1000)

            gasVehicle.drive { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }
            electricVehicle.drive { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }

            delay(1000)

            gasVehicle.stop { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }
            electricVehicle.stop { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }

            delay(3000)

            restaurant.eat { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }

            delay(3000)

            gasVehicle.start { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }
            electricVehicle.start {
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(it))
                }

            }

            delay(1000)

            gasVehicle.drive { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }
            electricVehicle.drive { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }

            delay(1000)

            gasVehicle.stop { sound ->
                _uiState.update { state ->
                    state.copy(checkPoints = state.checkPoints.plus(sound))
                }
            }
            electricVehicle.stop { sound ->
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