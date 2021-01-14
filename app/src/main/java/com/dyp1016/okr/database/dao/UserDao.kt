package com.dyp1016.okr.database.dao

import androidx.room.*
import com.dyp1016.okr.database.entity.UserEntity
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface UserDao {
    @Query("select * from TB_USER order by age")
    fun getAll(): List<UserEntity>

    /**
     * 查询所有的user, 且在数据库中user信息发生改变时, 继续触发回调
     */
    @Query("select * from TB_USER order by age")
    fun getAll2(): Observable<List<UserEntity>>

    /**
     * 查询所有的user, 不会继续触发回调
     */
    @Query("select * from TB_USER order by age")
    fun getAll3(): Single<List<UserEntity>>

    @Query("select * from TB_USER where name=:name limit 1")
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