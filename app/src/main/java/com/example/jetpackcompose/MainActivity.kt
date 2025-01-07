package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewElevatedButton() {
    ElevatedButton(
        elevation = ButtonDefaults.buttonElevation(2.dp),
        onClick = { }
    ) {
        Text("Explorer")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFilledButton() {
    Button(
        onClick = { }
    ) {
        Text("Button")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTonalButton() {
    FilledTonalButton(
        onClick = { }
    ) {
        Text("Button")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOutlinedButton() {
    OutlinedButton(
        onClick = {}
    ) {
        Text("Button")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextButton() {
    TextButton(
        onClick = { }
    ) {
        Text("Click")
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCustomButton() {
    Button(
        enabled = true,
        shape = RoundedCornerShape(5.dp),
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Green,
            contentColor = Color.Black
        )
    ) {
        Text("Button")
    }
}

@Preview
@Composable
private fun PreviewButtonWithBadge() {
    Box(
        modifier = Modifier.padding(4.dp)
    ) {
        Button(
            onClick = { }
        ) {
            Text("Message")
        }

        Badge(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = (-2).dp, y = 2.dp)
        ) {
            Text("2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIconButton() {
    IconButton(
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        onClick = {}
    ) {
        Icon(
            imageVector = Icons.Filled.Call,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun PreviewIconButtonWithText() {
    Button(
        onClick = {}
    ) {
        Icon(
            imageVector = Icons.Filled.Call,
            contentDescription = null
        )

        Spacer(Modifier.width(4.dp))

        Text("Call")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCheckBoxButton() {
    var checkedState by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = { checkedState = it }
        )

        Text(text = if (checkedState) "Checked" else "Unchecked")
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSwitchButton() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text =  "Switch : ${if (isChecked) "(ON)" else "(OFF)"}")

        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )

    }
}