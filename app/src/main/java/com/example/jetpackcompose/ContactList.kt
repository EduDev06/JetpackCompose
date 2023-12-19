package com.example.jetpackcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ContactList(
    modifier: Modifier = Modifier,
    contacts: List<Contact>
) {
    Box(modifier = modifier) {
        val listState = rememberLazyListState()
        val showButton by remember {
            derivedStateOf {
                listState.firstVisibleItemIndex > 0
            }
        }

        LazyColumn(state = listState) {
            items(contacts, key = { contact -> contact.id }) { contact ->
                ContactItem(contact = contact)
            }
        }

        AnimatedVisibility(
            visible = showButton,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp)
        ) {
            ScrollButton()
        }
    }
}

@Composable
fun ContactItem(
    contact: Contact
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Text(text = contact.name, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = contact.age.toString(), style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun ScrollButton() {
    ExtendedFloatingActionButton(
        onClick = {  },
        icon = { Icon(Icons.Filled.Edit, "Edit Contact") },
        text = { Text(text = "Edit") }
    )
}