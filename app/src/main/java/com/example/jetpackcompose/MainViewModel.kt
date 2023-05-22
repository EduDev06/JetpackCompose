package com.example.jetpackcompose

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainViewModel: ViewModel() {

    var showDialog by mutableStateOf(false)
        private set

    fun onDialogConfirm() {
        showDialog = false
    }

    fun onDialogDismiss() {
        showDialog = false
    }

    fun openDialog() {
        showDialog = true
    }
}