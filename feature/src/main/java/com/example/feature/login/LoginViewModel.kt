package com.example.feature.login


import androidx.lifecycle.viewModelScope
import com.example.domain.models.GeneralError
import com.example.domain.models.Resource
import com.example.domain.models.login.LoginParamDataModel
import com.example.domain.models.register.RegisterParamDataModel
import com.example.domain.usecases.login.GetLoginUseCase
import com.example.domain.usecases.login.LoginUseCase
import com.example.ui_component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUseCase,
    private val loginUseCase: LoginUseCase
) :
    BaseViewModel<LoginContract.LoginViewEvent, LoginContract.LoginViewState, LoginContract.LoginViewEffect>() {
    override fun createInitialState(): LoginContract.LoginViewState {
        return LoginContract.LoginViewState.Loading
    }

    init {
        getLoginForm()
    }

    override fun handleEvent(event: LoginContract.LoginViewEvent) {
        when (event) {
            LoginContract.LoginViewEvent.GetLoginForm -> getLoginForm()
            is LoginContract.LoginViewEvent.Login -> login(
                event.email,
                event.password
            )
        }
    }

    private fun getLoginForm() {
        viewModelScope.launch {
            when (val r = getLoginUseCase.execute(Unit)) {
                is Resource.Failure -> {
                    setState { LoginContract.LoginViewState.Failed }
                }

                is Resource.Success -> {
                    setState { LoginContract.LoginViewState.Success(list = r.data.item) }
                }
            }

        }
    }
    private fun login(email: String, password: String) {
        viewModelScope.launch {
            when (val r = loginUseCase.execute(
                LoginParamDataModel(
                    email = email,
                    password = password
                )
            )) {
                is Resource.Failure -> {
                    when (val error = r.error) {
                        is GeneralError.ApiError -> {
                            setEffect { LoginContract.LoginViewEffect.ShowMessage(error.message.toString()) }
                        }

                        GeneralError.NetworkError -> {
                            setEffect { LoginContract.LoginViewEffect.ShowMessage(error.toString()) }
                        }

                        is GeneralError.UnknownError -> {
                            setEffect { LoginContract.LoginViewEffect.ShowMessage(error.error.toString()) }
                        }
                    }
                }

                is Resource.Success -> {
                    setEffect { LoginContract.LoginViewEffect.ShowMessage("Account Login Successfully") }
                }
            }
        }
    }
}