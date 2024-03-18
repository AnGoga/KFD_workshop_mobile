package com.angoga.kfd_workshop_mobile.remote.model.request

import kotlinx.serialization.Serializable

@Serializable
class RegistrationRequest(
    val email: String,
    val password: String,
    val name: String,
)