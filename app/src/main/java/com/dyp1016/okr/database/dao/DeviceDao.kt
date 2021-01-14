package com.dyp1016.okr.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.dyp1016.okr.database.entity.DeviceEntity

@Dao
interface DeviceDao {
    @Query("SELECT * FROM tb_device")
    fun getAll(): List<DeviceEntity>
}