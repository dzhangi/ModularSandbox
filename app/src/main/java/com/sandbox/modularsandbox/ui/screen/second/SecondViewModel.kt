package com.sandbox.modularsandbox.ui.screen.second

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sandbox.modularsandbox.data.JokeApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val jokeApi: JokeApi,
) : ViewModel() {

    private val _state = MutableStateFlow(SecondFragmentUIState())
    val state = _state.asStateFlow()

    fun fetchRandomJoke() {
        viewModelScope.launch {
            _state.update { state -> state.loadingState() }
            runCatching { jokeApi.fetchJoke() }
                .onFailure {
                    Log.e("TEST", it.message ?: "Error fetching joke", it)
                    _state.update { state -> state.errorState() }
                }
                .onSuccess {
                    _state.update { state -> state.successState(it.value) }
                }
        }
    }
}