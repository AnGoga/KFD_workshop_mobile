package com.angoga.kfd_workshop_mobile.remote.model.response.user

import kotlinx.serialization.Serializable


@Serializable
class UserResponse(
    val id: Long,
    val email: String,
    val name: String
)