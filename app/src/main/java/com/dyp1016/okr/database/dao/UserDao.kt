package com.dyp1016.okr.database.dao

import androidx.room.*
import com.dyp1016.okr.database.entity.UserEntity

@Dao
interface UserDao {
    @Query("select * from TB_USER order by age")
    fun getAll(): List<UserEntity>

    @Query("select * from TB_USER where name=:name")
    fun getUser(name: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<UserEntity>)

    @Update
    fun update(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}