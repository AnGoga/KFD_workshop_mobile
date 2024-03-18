package com.angoga.kfd_workshop_mobile.remote.service

import com.angoga.kfd_workshop_mobile.remote.model.request.LoginRequest
import com.angoga.kfd_workshop_mobile.remote.model.request.PublicationRequest
import com.angoga.kfd_workshop_mobile.remote.model.request.RegistrationRequest
import io.ktor.client.statement.*

interface HttpService {

    suspend fun login(request: LoginRequest): HttpResponse
    suspend fun register(request: RegistrationRequest): HttpResponse
    suspend fun getSelfProfile(): HttpResponse
    suspend fun register(userId: Long): HttpResponse
    suspend fun getPublicationsPage(page: Int, size: Int): HttpResponse
    suspend fun getPublicationById(publicationId: Long): HttpResponse
    suspend fun likePublication(publicationId: Long, isLiked: Boolean): HttpResponse
    suspend fun createPublication(request: PublicationRequest): HttpResponse
}