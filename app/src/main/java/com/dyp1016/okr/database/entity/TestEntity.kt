package com.dyp1016.okr.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_test")
data class TestEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String,
    var age: Int,
    var sex: Int,
    var info: String? = null
)