package com.dyp1016.okr.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_device")
data class DeviceEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String,
    var uid: String,
    var status: Long
)
