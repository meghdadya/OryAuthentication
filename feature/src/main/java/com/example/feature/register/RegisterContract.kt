package com.example.feature.register

import com.example.domain.models.register.RegisterDomainModel
import com.example.ui_component.base.BaseContract

class RegisterContract {

    sealed class RegisterViewEvent : BaseContract.UiEvent {

        data object GetRegisterForm : RegisterViewEvent()

        data class Register(
            val items:List<RegisterUiModel>
        ) : RegisterViewEvent()

    }

    sealed class RegisterViewState : BaseContract.UiState {
        data object Loading : RegisterViewState()
        data object Failed : RegisterViewState()
        data class Success(val list: List<RegisterUiModel>):RegisterViewState()
    }

    sealed class RegisterViewEffect() : BaseContract.UiEffect {
        data class ShowMessage(val message: String) : RegisterViewEffect()
    }

}