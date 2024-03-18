package com.angoga.kfd_workshop_mobile.database.mappers

import com.angoga.kfd_workshop_mobile.database.entity.PublicationEntity
import com.angoga.kfd_workshop_mobile.remote.model.response.PageResponse
import com.angoga.kfd_workshop_mobile.remote.model.response.PublicationResponse
import com.angoga.kfd_workshop_mobile.ui.screens.create_news.PublicationRepository

object PublicationMapper {
    fun asEntity(publication: PublicationResponse): PublicationEntity {
        return PublicationEntity(
            id = publication.id,
            title = publication.title,
            content = publication.content,
            isLiked = publication.isLiked,
        )
    }

    fun asResponse(publication: PublicationEntity): PublicationResponse {
        return PublicationResponse(
            id = publication.id,
            title = publication.title,
            content = publication.content,
            isLiked = publication.isLiked,
        )
    }

    fun asPageResponse(list: List<PublicationEntity>): PageResponse<PublicationResponse> {
        return PageResponse(list.map { asResponse(it) })
    }
}