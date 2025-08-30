package com.example.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember

class MainState(
    val coroutineScope: CoroutineScope,
    val snackBarHostState: SnackbarHostState,
    val navController: NavController
)

@Composable
fun rememberMainState(
    navController: NavController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
): MainState {
    return remember(
        navController,
        coroutineScope,
        snackBarHostState,
    ) {
        MainState(
            coroutineScope = coroutineScope,
            snackBarHostState = snackBarHostState,
            navController = navController,
        )
    }
}