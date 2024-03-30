package com.example.feature.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ui_component.base.SIDE_EFFECTS_KEY
import com.example.ui_component.mToast
import com.example.ui_component.ui.component.OryCheckboxWithLabel
import com.example.ui_component.ui.component.OryOutlinedTextField
import kotlinx.coroutines.flow.onEach


@Composable
fun RegisterRoute(
    viewModel: RegisterViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach { effect ->
            when (effect) {
                is RegisterContract.RegisterViewEffect.ShowMessage -> {
                    mToast(context, effect.message)
                }
            }
        }.collect {}
    }

    when (val state = viewModel.viewState.value) {
        RegisterContract.RegisterViewState.Failed -> {}
        RegisterContract.RegisterViewState.Loading -> {

        }

        is RegisterContract.RegisterViewState.Success -> {
            RegisterScreen(items = state.list) { list ->
                viewModel.handleEvent(
                    RegisterContract.RegisterViewEvent.Register(
                        list
                    )
                )
            }
        }
    }

}

@Composable
fun RegisterScreen(items: List<RegisterUiModel>, onClicked: (List<RegisterUiModel>) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        Text(text = "Register", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(16.dp))

        items.forEachIndexed { index, item ->
            when (val value = item.value) {
                is ValueType.BooleanValue -> {
                    val checkedState = remember { mutableStateOf(value.value) }
                    (items[index].value as ValueType.BooleanValue).value = checkedState.value
                    OryCheckboxWithLabel(
                        checkedState = checkedState,
                        label = item.label
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                is ValueType.IntValue -> {
                    val intValueState = remember { mutableStateOf(value.value ?: "") }
                    OryOutlinedTextField(
                        value = intValueState.value,
                        onValueChange = {
                            intValueState.value = it
                            (items[index].value as ValueType.IntValue).value = it
                        },
                        label = item.label
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                is ValueType.StringValue -> {
                    val stringValueState = remember { mutableStateOf(value.value ?: "") }
                    OryOutlinedTextField(
                        value = stringValueState.value,
                        onValueChange = {
                            stringValueState.value = it
                            (items[index].value as ValueType.StringValue).value = it
                        },
                        label = item.label
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                null -> {
                    // Handle null case if needed
                }
            }
        }

        Button(onClick = {
          onClicked(items)

        }, modifier = Modifier.width(200.dp)) {
            Text(text = "Submit")
        }
    }
}



