package com.angoga.kfd_workshop_mobile.remote.model.response.common

import com.angoga.kfd_workshop_mobile.remote.model.response.common.AbstractResponse
import java.time.LocalDateTime

abstract class AbstractCreatedAtResponse(
    id: Long,
    val createdAt: LocalDateTime
): AbstractResponse(id)