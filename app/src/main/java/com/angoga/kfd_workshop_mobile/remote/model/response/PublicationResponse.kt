package com.angoga.kfd_workshop_mobile.remote.model.response

import com.angoga.kfd_workshop_mobile.remote.model.response.common.AbstractCreatedAtResponse
import java.time.LocalDateTime

class PublicationResponse(
    id: Long,
    createdAt: LocalDateTime,
    var title: String,
    var content: String,
    var isLiked: Boolean = false
): AbstractCreatedAtResponse(id, createdAt)