package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel by viewModels<MainViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            JetpackComposeTheme {
                Content(
                    contacts = uiState.contact,
                    onSortValue = viewModel::updateContacts
                )
            }
        }
    }
}

@Composable
fun Content(
    contacts: List<Contact>,
    onSortValue: (SortStrategy) -> Unit
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { onSortValue(AgeSort()) }) {
                    Text(text = "Order by age")
                }

                Button(onClick = { onSortValue(NameSort()) }) {
                    Text(text = "Order by name")
                }
            }
            ContactList(
                modifier = Modifier.fillMaxSize(),
                contacts = contacts
            )
        }
    }
}