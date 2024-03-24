package com.example.feature.register


import androidx.lifecycle.viewModelScope
import com.example.domain.models.GeneralError
import com.example.domain.models.Resource
import com.example.domain.models.register.RegisterParamDataModel
import com.example.domain.usecases.register.GetRegisterUseCase
import com.example.domain.usecases.register.RegisterUseCase
import com.example.feature.login.LoginContract
import com.example.ui_component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val getRegisterUseCase: GetRegisterUseCase,
    private val registerUseCase: RegisterUseCase
) :
    BaseViewModel<RegisterContract.RegisterViewEvent, RegisterContract.RegisterViewState, RegisterContract.RegisterViewEffect>() {
    override fun createInitialState(): RegisterContract.RegisterViewState {
        return RegisterContract.RegisterViewState.Loading
    }

    init {
        getRegisterForm()
    }

    override fun handleEvent(event: RegisterContract.RegisterViewEvent) {
        when (event) {
            RegisterContract.RegisterViewEvent.GetRegisterForm -> getRegisterForm()
            is RegisterContract.RegisterViewEvent.Register -> register(
                event.email,
                event.password,
                event.fullName
            )
        }
    }


    private fun getRegisterForm() {
        viewModelScope.launch {
            when (val r = getRegisterUseCase.execute(Unit)) {
                is Resource.Failure -> {
                    setState { RegisterContract.RegisterViewState.Failed }
                }

                is Resource.Success -> {
                    setState { RegisterContract.RegisterViewState.Success(list = r.data.item) }
                }
            }

        }
    }

    private fun register(email: String, password: String, fullName: String) {
        viewModelScope.launch {
            when (val r = registerUseCase.execute(
                RegisterParamDataModel(
                    email = email,
                    password = password,
                    fullName = fullName
                )
            )) {
                is Resource.Failure -> {
                    when (val error = r.error) {
                        is GeneralError.ApiError -> {
                            setEffect { RegisterContract.RegisterViewEffect.ShowMessage(error.message.toString()) }
                        }

                        GeneralError.NetworkError -> {
                            setEffect { RegisterContract.RegisterViewEffect.ShowMessage(error.toString()) }
                        }

                        is GeneralError.UnknownError -> {
                            setEffect { RegisterContract.RegisterViewEffect.ShowMessage(error.error.toString()) }
                        }
                    }
                }

                is Resource.Success -> {
                    setEffect { RegisterContract.RegisterViewEffect.ShowMessage("Account Created") }
                }
            }
        }
    }
}