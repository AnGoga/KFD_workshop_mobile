package com.angoga.kfd_workshop_mobile.remote.model.request

import kotlinx.serialization.Serializable


@Serializable
class PageRequest(
    val page: Int = 1,
    val size: Int = 10,
)