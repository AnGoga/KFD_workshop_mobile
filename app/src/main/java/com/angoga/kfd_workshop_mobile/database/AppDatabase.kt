package com.angoga.kfd_workshop_mobile.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.angoga.kfd_workshop_mobile.database.dao.PublicationDao
import com.angoga.kfd_workshop_mobile.database.entity.PublicationEntity


@Database(entities = [PublicationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPublicationDao(): PublicationDao
}