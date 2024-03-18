package com.angoga.kfd_workshop_mobile.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.angoga.kfd_workshop_mobile.database.entity.PublicationEntity

@Dao
interface PublicationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(publication: PublicationEntity)

    @Delete
    fun delete(publication: PublicationEntity)

    @Query("SELECT * FROM PublicationEntity LIMIT :size OFFSET (:page * :size)")
    fun getAll(page: Int = 1, size: Int = 50): List<PublicationEntity>
}