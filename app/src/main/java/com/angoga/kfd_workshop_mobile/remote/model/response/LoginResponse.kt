package com.angoga.kfd_workshop_mobile.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
class LoginResponse(
    val accessJwt: String = ""
)
