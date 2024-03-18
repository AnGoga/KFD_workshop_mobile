package com.angoga.kfd_workshop_mobile.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
class PageResponse<T>(
    val content: List<T> = emptyList(),
    val page: Long = -1,
    val size: Long = -1,
    val totalPages: Long = -1,
)