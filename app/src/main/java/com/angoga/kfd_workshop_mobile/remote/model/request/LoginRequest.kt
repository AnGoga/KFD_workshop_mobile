package com.angoga.kfd_workshop_mobile.remote.model.request

import kotlinx.serialization.Serializable

@Serializable
class LoginRequest(
    val email: String,
    val password: String
)