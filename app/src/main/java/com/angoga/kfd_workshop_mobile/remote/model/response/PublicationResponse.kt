package com.angoga.kfd_workshop_mobile.remote.model.response

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
class PublicationResponse(
    val id: Long,
    var title: String,
    var content: String,
    var isLiked: Boolean = false
)