package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Content(contacts = fakeContacts)
            }
        }
    }
}

@Composable
fun Content(
    contacts: List<Contact>
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            var comparator by remember { mutableStateOf(ageComparator) }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { comparator = ageComparator }) {
                    Text(text = "Order by age")
                }

                Button(onClick = { comparator = nameComparator }) {
                    Text(text = "Order by name")
                }
            }
            ContactList(
                modifier = Modifier.fillMaxSize(),
                comparator = comparator,
                contacts = contacts
            )
        }
    }
}

private val ageComparator = Comparator<Contact> { contact1, contact2 ->
    contact1.age.compareTo(contact2.age)
}

private val nameComparator = Comparator<Contact> { contact1, contact2 ->
    contact1.name.compareTo(contact2.name)
}