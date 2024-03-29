package com.angoga.kfd_workshop_mobile.remote.model.response.common


class PageResponse<T>(
    val content: List<T>,
    val page: Long,
    val size: Long,
    val totalPages: Long,
)