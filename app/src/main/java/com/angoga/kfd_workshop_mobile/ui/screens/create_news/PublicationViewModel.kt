package com.angoga.kfd_workshop_mobile.ui.screens.create_news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angoga.kfd_workshop_mobile.remote.model.Result
import com.angoga.kfd_workshop_mobile.remote.model.request.PublicationRequest
import com.angoga.kfd_workshop_mobile.remote.model.response.PageResponse
import com.angoga.kfd_workshop_mobile.remote.model.response.PublicationResponse
import com.angoga.kfd_workshop_mobile.remote.service.HttpService
import io.ktor.client.call.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class PublicationViewModel(
    private val httpService: HttpService,
    private val repository: PublicationRepository
) : ViewModel() {
    private val _flow = MutableSharedFlow<Result<PublicationResponse>>()
    val flow: SharedFlow<Result<PublicationResponse>> = _flow


    fun createPublication(title: String, content: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = httpService.createPublication(PublicationRequest(title, content))
                    .body<PublicationResponse>()


                _flow.emit(Result.Success(response))
            } catch (e: Exception) {
                e.printStackTrace()
                _flow.emit(Result.Error(e))
            }
        }
    }

    fun getNextPublication() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getNextPublication(1, 50)
            println(result)
            when(result) {
                is Result.Error -> {
                    _flow.emit(Result.Error(result.e))
                    result.e.printStackTrace()
                }
                is Result.Success -> {
                    result.data.content.forEach { _flow.emit(Result.Success(it)) }
                }
            }
        }
    }
}