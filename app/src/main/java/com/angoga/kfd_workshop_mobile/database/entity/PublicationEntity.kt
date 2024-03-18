package com.angoga.kfd_workshop_mobile.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
class PublicationEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Long,

    @ColumnInfo(name = "createdAt")
    var createdAt: LocalDateTime,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "isLiked")
    var isLiked: Boolean = false,

    @ColumnInfo(name = "likesCount")
    var likesCount: Int = 0
)