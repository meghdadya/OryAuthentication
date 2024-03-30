package com.example.feature.register


import androidx.lifecycle.viewModelScope
import com.example.domain.models.GeneralError
import com.example.domain.models.Resource
import com.example.domain.models.register.RegisterDomainModel
import com.example.domain.models.register.RegisterFiledType
import com.example.domain.models.register.RegisterParamDataModel
import com.example.domain.usecases.register.GetRegisterUseCase
import com.example.domain.usecases.register.RegisterUseCase
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
                convertListToMap(event.items)
            )
        }
    }

    private fun convertListToMap(registerUiModels: List<RegisterUiModel>): Map<String, Any> {
        val resultMap = mutableMapOf<String, Any>()

        for (model in registerUiModels) {
            val name = model.name
            val value = model.value?.let { getValueAsString(it) } ?: Any()
            resultMap[name] = value
        }

        return resultMap
    }

    private fun getValueAsString(value: ValueType): Any {
        return when (value) {
            is ValueType.IntValue -> value.value?.toInt() ?: 0
            is ValueType.BooleanValue -> value.value
            is ValueType.StringValue -> value.value ?: ""
        }
    }

    private fun getRegisterForm() {
        viewModelScope.launch {
            when (val r = getRegisterUseCase.execute(Unit)) {
                is Resource.Failure -> {
                    setState { RegisterContract.RegisterViewState.Failed }
                }

                is Resource.Success -> {
                    setState {
                        RegisterContract.RegisterViewState.Success(list = r.data.item.map {
                            mapToRegisterUiModel(
                                it
                            )
                        })
                    }
                }
            }

        }
    }

    private fun mapToRegisterUiModel(registerDomainModel: RegisterDomainModel): RegisterUiModel {
        val label = registerDomainModel.label
        val name = registerDomainModel.name

        val value = when (registerDomainModel.type) {
            RegisterFiledType.PASSWORD, RegisterFiledType.TEL, RegisterFiledType.EMAIL, RegisterFiledType.TEXT -> ValueType.StringValue(
                null
            )

            RegisterFiledType.NUMBER -> ValueType.IntValue(null)
            RegisterFiledType.CHECKBOX -> ValueType.BooleanValue(false)
            null -> null
        }

        return RegisterUiModel(name = name, label = label, value)
    }

    private fun register(params: Map<String, Any>) {
        viewModelScope.launch {
            when (val r = registerUseCase.execute(
                RegisterParamDataModel(
                    params = params
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