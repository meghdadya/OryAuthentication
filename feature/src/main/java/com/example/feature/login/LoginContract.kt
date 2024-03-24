package com.example.feature.login

import com.example.domain.models.login.LoginDomainModel
import com.example.domain.models.register.RegisterDomainModel
import com.example.ui_component.base.BaseContract

class LoginContract {

    sealed class LoginViewEvent : BaseContract.UiEvent {

        data object GetLoginForm : LoginViewEvent()

        data class Login(
            val email: String, val password: String
        ) : LoginViewEvent()

    }

    sealed class LoginViewState : BaseContract.UiState {
        data object Loading : LoginViewState()
        data object Failed : LoginViewState()
        data class Success(val list: List<LoginDomainModel>): LoginViewState()
    }

    sealed class LoginViewEffect() : BaseContract.UiEffect {
        data class ShowMessage(val message: String) : LoginViewEffect()
    }

}