package com.example.ui_component.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment

@Composable
fun OryCheckboxWithLabel(
    checkedState: MutableState<Boolean>,
    label: String
) {
    Row (verticalAlignment = Alignment.CenterVertically){
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { isChecked ->
                checkedState.value = isChecked
            }
        )
        Text(text = label)
    }
}
