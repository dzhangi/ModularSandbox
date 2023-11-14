package com.sandbox.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sandbox.login.ui.theme.ModularSandboxTheme

@Composable
fun SecondScreen(
    viewModel: LoginViewModel,
    navController: NavController,
//    args: LoginFragmentArgs,
) {
    val uiState by viewModel.state.collectAsState()

    ModularSandboxTheme {
        Surface {
            Column {
//                Text(text = args.testArg.toString())
                SimpleButton(text = "Go to first fragment") {
                    navController.navigateUp()
                }
                SimpleButton(text = "Fetch random joke from API") {
                    viewModel.fetchRandomJoke()
                }
                if (uiState.isLoading) CircularProgressIndicator()
                Text(text = uiState.joke)
            }
        }
    }
}

@Composable
fun SimpleButton(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.wrapContentSize(),
        enabled = enabled,
    ) {
        Text(text = text)
    }
}