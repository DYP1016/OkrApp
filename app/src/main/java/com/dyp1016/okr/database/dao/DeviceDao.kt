package com.dyp1016.okr.database.dao

import androidx.room.*
import com.dyp1016.okr.database.entity.DeviceEntity

@Dao
interface DeviceDao {
    @Query("SELECT * FROM tb_device")
    fun getAll(): List<DeviceEntity>
}