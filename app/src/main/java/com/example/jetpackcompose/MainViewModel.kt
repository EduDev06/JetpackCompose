package com.example.jetpackcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _permissionState = MutableStateFlow(PermissionState.NO_ACTION)
    val permissionState = _permissionState.asStateFlow()

    private val _events = Channel<Events>()
    val events = _events.receiveAsFlow()

    fun updatePermissionEvent(
        isGranted: Boolean,
        shouldShowPermissionRationale: Boolean
    ) {
        viewModelScope.launch {
            when {
                isGranted -> _events.send(Events.ShowGrantedText)
                shouldShowPermissionRationale -> _events.send(Events.ShowPermissionRationale)
                else -> _events.send(Events.SendToSettings)
            }
        }
    }

    fun updatePermissionState(permissionState: PermissionState) {
        _permissionState.value = permissionState
    }
}

sealed class Events {
    data object ShowGrantedText: Events()
    data object ShowPermissionRationale: Events()
    data object SendToSettings: Events()
}

enum class PermissionState {
    GRANTED,
    SHOULD_SHOW_PERMISSION_RATIONALE,
    NO_ACTION
}