package com.sandbox.modularsandbox.ui.screen.second

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.sandbox.modularsandbox.ui.screen.first.SimpleButton
import com.sandbox.modularsandbox.ui.theme.ModularSandboxTheme

@Composable
fun SecondScreen(
    viewModel: SecondViewModel,
    navController: NavController,
    args: SecondFragmentArgs,
) {
    val uiState by viewModel.state.collectAsState()

    ModularSandboxTheme {
        Surface {
            Column {
                Text(text = args.testArg.toString())
                SimpleButton(text = "Go to first fragment") {
                    navController.navigateUp()
                }
                SimpleButton(text = "Fetch random joke from API") {
                    viewModel.fetchRandomJoke()
                }
                Text(text = uiState.joke)
            }
        }
    }
}