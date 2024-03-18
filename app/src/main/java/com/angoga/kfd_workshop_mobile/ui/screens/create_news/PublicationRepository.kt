package com.angoga.kfd_workshop_mobile.ui.screens.create_news

import androidx.room.RoomDatabase
import com.angoga.kfd_workshop_mobile.App
import com.angoga.kfd_workshop_mobile.database.AppDatabase
import com.angoga.kfd_workshop_mobile.database.mappers.PublicationMapper
import com.angoga.kfd_workshop_mobile.remote.model.Result
import com.angoga.kfd_workshop_mobile.remote.model.response.PageResponse
import com.angoga.kfd_workshop_mobile.remote.model.response.PublicationResponse
import com.angoga.kfd_workshop_mobile.remote.service.HttpService
import io.ktor.client.call.body
import kotlin.random.Random


class PublicationRepository(
    private val httpService: HttpService,
    private val database: AppDatabase
) {

    suspend fun getNextPublication(page: Int, size: Int): Result<PageResponse<PublicationResponse>> {
        println("================================================")
        return try {
            // TODO:
//            val response = httpService.getPublicationsPage(1, 50).body<PageResponse<PublicationResponse>>()
            val response = PageResponse<PublicationResponse>(
                (0..10).map { PublicationResponse(it.toLong(), it.toString(), it.toString(), Random.nextBoolean()) }
            )
            println(response.content)

            response.content.forEach {
                database.getPublicationDao().insert(PublicationMapper.asEntity(it))
            }

            Result.Success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            val result = database.getPublicationDao().getAll(page, size)
            Result.Success(PublicationMapper.asPageResponse(result))
        }
    }
}