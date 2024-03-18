package com.angoga.kfd_workshop_mobile.remote.service.impl

import android.content.Context
import com.angoga.kfd_workshop_mobile.remote.model.request.LoginRequest
import com.angoga.kfd_workshop_mobile.remote.model.request.PageRequest
import com.angoga.kfd_workshop_mobile.remote.model.request.PublicationRequest
import com.angoga.kfd_workshop_mobile.remote.model.request.RegistrationRequest
import io.ktor.client.*
import io.ktor.client.request.*
import com.angoga.kfd_workshop_mobile.remote.service.HttpService
import io.ktor.http.HttpHeaders

class HttpServiceImpl(
    private val client: HttpClient,
    private val context: Context
) : HttpService {

    // ---------------- AUTH --------------------
    override suspend fun login(request: LoginRequest) = client.post("$BASE_URL_PUBLIC/auth") {
        addContentTypeHeader()
        setBody(request)
    }

    override suspend fun register(request: RegistrationRequest) =
        client.post("$BASE_URL_PUBLIC/registration") {
            addContentTypeHeader()
            setBody(request)
        }

    // ---------------- USER --------------------

    override suspend fun getSelfProfile() = client.get("$BASE_URL/user/me") { addJwt() }

    override suspend fun register(userId: Long) =
        client.get("$BASE_URL/user?userId=$userId") { addJwt() }


    // ---------------- PUBLICATION --------------------

    override suspend fun getPublicationsPage(page: Int, size: Int) =
        client.get("$BASE_URL/publication/list?page=$page&size=$size") {
            addJwt()
        }

    override suspend fun getPublicationById(publicationId: Long) =
        client.get("$BASE_URL/publication/$publicationId") {
            addJwt()
        }

    override suspend fun createPublication(request: PublicationRequest) =
        client.get("$BASE_URL/publication") {
            setBody(request)
            addJwt()
        }

    override suspend fun likePublication(publicationId: Long, isLiked: Boolean) =
        client.get("$BASE_URL/publication/$publicationId/like?isLiked=$isLiked") {
            addJwt()
        }


    companion object {
        private const val BASE_URL = "http://192.168.1.3:8080/api/v1"
        private const val BASE_URL_PUBLIC = "$BASE_URL/public"
    }

    private fun HttpRequestBuilder.addContentTypeHeader() {
        headers {
            append(HttpHeaders.ContentType, "application/json")
        }
    }

    private fun HttpRequestBuilder.addJwt() {
        addContentTypeHeader()
        val jwt = context.getSharedPreferences("JWT", Context.MODE_PRIVATE).getString("JWT", null) ?: return
        headers {
            append(HttpHeaders.Authorization, "Bearer $jwt")
        }
    }
}