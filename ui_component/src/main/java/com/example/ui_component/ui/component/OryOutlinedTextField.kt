package com.example.ui_component.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OryOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    enabled: Boolean = true,
    isRequired: Boolean = false
) {
    OutlinedTextField(
        value = value, onValueChange = onValueChange, label = {
            Row {
                Text(text = label)
                if (isRequired) {
                    Spacer(modifier = Modifier.width(1.dp))
                    Text(text = "*", color = Color.Blue)
                }
            }
        }, enabled = enabled, singleLine = true
    )
}