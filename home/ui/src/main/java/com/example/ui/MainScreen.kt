package com.example.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ui.state.rememberMainState

@Composable
fun MainScreen(
    modifier: Modifier,
) {

    val mainState = rememberMainState()

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        snackbarHost = {
            mainState.snackBarHostState
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("asodkapsokdpasokdpaoskdpaoskdpo")
        }
    }
}