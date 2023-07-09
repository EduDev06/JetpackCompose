package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                MyContent()
            }
        }
    }
}

@Composable
fun MyContent() {
    /*
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ExtendedFAB(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
     */
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        SmallFAB()
        Spacer(modifier = Modifier.height(8.dp))
        ExtendedFAB()
    }
}

@Composable
fun StandardFAB(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add something",
            tint = Color.White
        )
    }
}

@Composable
fun LargeFAB(modifier: Modifier = Modifier) {
    LargeFloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add something",
            tint = Color.White
        )
    }
}

@Composable
fun SmallFAB(modifier: Modifier = Modifier) {
    SmallFloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add something",
            tint = Color.White
        )
    }
}

@Composable
fun ExtendedFAB(modifier: Modifier = Modifier) {
    ExtendedFloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add something",
            tint = Color.White
        )
        Text(text = "Add something")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        MyContent()
    }
}