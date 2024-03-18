package com.angoga.kfd_workshop_mobile.ui.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angoga.kfd_workshop_mobile.remote.model.Result
import com.angoga.kfd_workshop_mobile.remote.model.request.LoginRequest
import com.angoga.kfd_workshop_mobile.remote.model.request.RegistrationRequest
import com.angoga.kfd_workshop_mobile.remote.model.response.LoginResponse
import com.angoga.kfd_workshop_mobile.remote.model.response.UserResponse
import com.angoga.kfd_workshop_mobile.remote.service.HttpService
import io.ktor.client.call.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val httpService: HttpService
) : ViewModel() {
    private val _flow = MutableSharedFlow<Result<UserResponse>>()
    val flow: SharedFlow<Result<UserResponse>> = _flow


    fun register(email: String, password: String, name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = httpService.register(RegistrationRequest(email, password, name)).body<UserResponse>()
                _flow.emit(Result.Success(response))
            } catch (e: Exception) {
                e.printStackTrace()
                _flow.emit(Result.Error(e))
            }
        }
    }
}