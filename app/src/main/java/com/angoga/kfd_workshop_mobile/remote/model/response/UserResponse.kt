package com.angoga.kfd_workshop_mobile.remote.model.response

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
open class UserResponse(
    val id: Long = -1,
    val email: String = "",
    val name: String = ""
)