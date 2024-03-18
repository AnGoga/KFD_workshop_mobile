package com.angoga.kfd_workshop_mobile.remote.model.request

import kotlinx.serialization.Serializable

@Serializable
class PublicationRequest(
    var title: String,
    var content: String
)