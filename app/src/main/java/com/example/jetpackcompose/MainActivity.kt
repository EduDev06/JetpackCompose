package com.example.jetpackcompose

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel by viewModels<MainViewModel>()
            val permissionState by viewModel.permissionState.collectAsState()

            HandleOneEvent(viewModel.events) {  events ->
                when (events) {
                    Events.SendToSettings -> openAppSettings()
                    Events.ShowGrantedText -> viewModel.updatePermissionState(PermissionState.GRANTED)
                    Events.ShowPermissionRationale -> viewModel.updatePermissionState(PermissionState.SHOULD_SHOW_PERMISSION_RATIONALE)
                }
            }

            JetpackComposeTheme {
                Content(
                    permissionState = permissionState,
                    updatePermissionState = viewModel::updatePermissionState,
                    updatePermissionEvent = viewModel::updatePermissionEvent
                )
            }
        }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    permissionState: PermissionState,
    updatePermissionState: (PermissionState) -> Unit,
    updatePermissionEvent: (Boolean, Boolean) -> Unit
) {
    val context = LocalContext.current
    val activity = context as Activity
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            val shouldShowPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                Manifest.permission.CAMERA
            )

            updatePermissionEvent(isGranted, shouldShowPermissionRationale)
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp)
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { permissionLauncher.launch(Manifest.permission.CAMERA) }
            ) {
                Text(
                    text = "Camera permission"
                )
            }
        }

        when (permissionState) {
            PermissionState.GRANTED -> Text(
                modifier = Modifier.align(Alignment.BottomCenter),
                text = "Permission Accepted"
            )

            PermissionState.SHOULD_SHOW_PERMISSION_RATIONALE -> PermissionDialog(
                onDismiss = { updatePermissionState(PermissionState.NO_ACTION) },
                onConfirmation = { permissionLauncher.launch(Manifest.permission.CAMERA) }
            )

            PermissionState.NO_ACTION -> Unit
        }
    }
}

private fun Activity.openAppSettings() {
    Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    ).also(::startActivity)
}