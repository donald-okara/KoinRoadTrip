package org.example.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel

class RoadTripScreen: Screen {
    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<RoadTripModel>()

        val state by screenModel.uiState.collectAsState()

        RoadTripScreenContent(
            state = state,
            onStart = screenModel::start
        )
    }
}

@Composable
fun RoadTripScreenContent(
    modifier: Modifier = Modifier,
    state: RoadTripState,
    onStart: () -> Unit
){
    Scaffold{ innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
        ) {
            Button(
                onClick = onStart,
                enabled = !state.isUpdating,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start")
            }

            Text(
                text = "Checkpoints"
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(state.checkPoints) {
                    Text(
                        text = it,
                        modifier = Modifier.animateItem()
                    )
                }
            }
        }
    }
}