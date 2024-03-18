package com.angoga.kfd_workshop_mobile.remote.service.impl

import com.angoga.kfd_workshop_mobile.remote.model.request.LoginRequest
import com.angoga.kfd_workshop_mobile.remote.model.request.PageRequest
import com.angoga.kfd_workshop_mobile.remote.model.request.RegistrationRequest
import io.ktor.client.*
import io.ktor.client.request.*
import com.angoga.kfd_workshop_mobile.remote.service.HttpService

class HttpServiceImpl(
    private val client: HttpClient
) : HttpService {

    // ---------------- AUTH --------------------
    override suspend fun login(request: LoginRequest)
        = client.post("$BASE_URL_PUBLIC/auth") { setBody(request) }

    override suspend fun register(request: RegistrationRequest)
        = client.post("$BASE_URL_PUBLIC/registration") { setBody(request) }

    // ---------------- USER --------------------

    override suspend fun getSelfProfile()
            = client.get("$BASE_URL/user/me")

    override suspend fun register(userId: Long)
            = client.get("$BASE_URL/user?userId=$userId")


    // ---------------- PUBLICATION --------------------

    override suspend fun getPublicationsPage(page: Int, size: Int)
            = client.get("$BASE_URL/publication/list") { setBody(PageRequest(page, size)) }

    override suspend fun getPublicationById(publicationId: Long)
            = client.get("$BASE_URL/publication/$publicationId")

    override suspend fun likePublication(publicationId: Long, isLiked: Boolean)
            = client.get("$BASE_URL/publication/$publicationId/like?isLiked=$isLiked")



    companion object {
        private const val BASE_URL = "http://localhost:8080/api/v1"
        private const val BASE_URL_PUBLIC = "$BASE_URL/public"
    }
}