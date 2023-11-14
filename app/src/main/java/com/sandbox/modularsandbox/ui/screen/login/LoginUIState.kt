package com.sandbox.modularsandbox.ui.screen.login

data class LoginUIState(
    val joke: String = "",
    val isLoading: Boolean = false,
) {
    fun successState(joke: String) =
        copy(
            isLoading = false,
            joke = joke
        )

    fun loadingState() = copy(
        isLoading = true,
        joke = ""
    )

    fun errorState() = copy(
        isLoading = false,
        joke = "Error fetching joke"
    )
}