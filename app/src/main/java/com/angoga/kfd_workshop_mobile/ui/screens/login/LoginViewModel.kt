package com.angoga.kfd_workshop_mobile.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angoga.kfd_workshop_mobile.remote.model.Result
import com.angoga.kfd_workshop_mobile.remote.model.request.LoginRequest
import com.angoga.kfd_workshop_mobile.remote.model.response.LoginResponse
import com.angoga.kfd_workshop_mobile.remote.service.HttpService
import io.ktor.client.call.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val httpService: HttpService
) : ViewModel() {
    private val _flow = MutableSharedFlow<Result<LoginResponse>>()
    val flow: SharedFlow<Result<LoginResponse>> = _flow


    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = httpService.login(LoginRequest(email, password)).body<LoginResponse>()
                _flow.emit(Result.Success(response))
            } catch (e: Exception) {
                e.printStackTrace()
                _flow.emit(Result.Error(e))
            }
        }
    }
}