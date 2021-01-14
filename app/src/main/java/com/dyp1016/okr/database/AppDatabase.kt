package com.dyp1016.okr.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dyp1016.okr.database.dao.DeviceDao
import com.dyp1016.okr.database.dao.UserDao
import com.dyp1016.okr.database.entity.DeviceEntity
import com.dyp1016.okr.database.entity.TestEntity
import com.dyp1016.okr.database.entity.UserEntity

@Database(entities = [UserEntity::class, DeviceEntity::class, TestEntity::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun deviceDao(): DeviceDao
}