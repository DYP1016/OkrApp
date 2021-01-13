package com.dyp1016.okr.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dyp1016.okr.database.dao.UserDao
import com.dyp1016.okr.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}