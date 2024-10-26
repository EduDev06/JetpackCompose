package com.example.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun PermissionDialog(
    onDismiss: () -> Unit,
    onConfirmation: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(330.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "This permission is required",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(Modifier.height(10.dp))

                Text(
                    text = "To use this app correctly is necessary to enable this permission",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(Modifier.height(10.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    onClick = onConfirmation
                ) {
                    Text(
                        text = "Yes, I want to enable the permission"
                    )
                }

                Spacer(Modifier.height(5.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray.copy(0.5F)
                    ),
                    shape = RoundedCornerShape(8.dp),
                    onClick = onDismiss
                ) {
                    Text(
                        text = "Cancel"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewDialog() {
    JetpackComposeTheme {
        PermissionDialog(
            onDismiss = { },
            onConfirmation = { }
        )
    }
}