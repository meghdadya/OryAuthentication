package com.example.feature.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.models.register.RegisterDomainModel
import com.example.domain.models.register.RegisterFiledType
import com.example.feature.login.LoginContract
import com.example.ui_component.base.SIDE_EFFECTS_KEY
import com.example.ui_component.mToast
import com.example.ui_component.ui.theme.LocalSpacing
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
            RegisterScreen(items = state.list) { email, password, fullName ->
                viewModel.handleEvent(
                    RegisterContract.RegisterViewEvent.Register(
                        email, password, fullName
                    )
                )
            }
        }
    }

}

@Composable
fun RegisterScreen(items: List<RegisterDomainModel>, onClicked: (String, String, String) -> Unit) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }


    var fullName by remember {
        mutableStateOf("")
    }
    val spacing = LocalSpacing.current



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp)
    ) {
        Text(text = "Register", fontSize = 26.sp)
        Spacer(modifier = androidx.compose.ui.Modifier.height(spacing.spaceExtraLarge))

        items.forEach { item ->
            when (item.type) {
                RegisterFiledType.HIDDEN -> {}
                RegisterFiledType.EMAIL -> {
                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                        },
                        label = {
                            Text(text = item.label)
                        },

                        enabled = true,
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                }

                RegisterFiledType.PASSWORD -> {
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                        },
                        label = {
                            Text(text = item.label)
                        },

                        enabled = true,
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                }

                RegisterFiledType.TEXT -> {
                    OutlinedTextField(
                        value = fullName,
                        onValueChange = {
                            fullName = it
                        },
                        label = {
                            Text(text = item.label)
                        },

                        enabled = true,
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                }

                RegisterFiledType.SUBMIT -> {
                    Button(onClick = {
                        onClicked(
                            email, password, fullName
                        )
                    }) {
                        Text(text = item.label)
                    }
                }
            }
        }

    }

}



