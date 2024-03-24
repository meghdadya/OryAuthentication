package com.example.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.models.login.LoginDomainModel
import com.example.domain.models.login.LoginFiledType
import com.example.ui_component.base.SIDE_EFFECTS_KEY
import com.example.ui_component.mToast
import com.example.ui_component.ui.theme.LocalSpacing
import kotlinx.coroutines.flow.onEach

@Composable
fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigate: () -> Unit
) {

    val context = LocalContext.current

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach { effect ->
            when (effect) {
                is LoginContract.LoginViewEffect.ShowMessage -> {
                    mToast(context, effect.message)
                }
            }
        }.collect {}
    }

    when (val state = viewModel.viewState.value) {
        LoginContract.LoginViewState.Failed -> {

        }
        LoginContract.LoginViewState.Loading -> {

        }

        is LoginContract.LoginViewState.Success -> {
            LoginScreen(items = state.list, onClicked = { email, password ->
                viewModel.handleEvent(
                    LoginContract.LoginViewEvent.Login(
                        email, password
                    )
                )
            }, onNavigate = onNavigate)
        }
    }

}

@Composable
fun LoginScreen(
    items: List<LoginDomainModel>,
    onClicked: (String, String) -> Unit,
    onNavigate: () -> Unit
) {


    val spacing = LocalSpacing.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp)
    ) {

        Text(text = "Login", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        items.forEach { item ->
            when (item.type) {
                LoginFiledType.HIDDEN -> {}
                LoginFiledType.EMAIL -> {
                }

                LoginFiledType.PASSWORD -> {
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

                LoginFiledType.TEXT -> {
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

                LoginFiledType.SUBMIT -> {
                    Button(onClick = {
                        onClicked(
                            email, password
                        )
                    }, modifier = Modifier.width(200.dp)) {
                        Text(text = item.label)
                    }
                }


            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Don't have an account? ")
            TextButton(onClick = onNavigate) {
                Text(text = "Sign up", color = Color.Blue)
            }
        }
    }

}



