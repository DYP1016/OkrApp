package com.dyp1016.okr.model.repository

import com.dyp1016.okr.database.DBManager
import com.dyp1016.okr.database.entity.UserEntity
import com.dyp1016.okr.model.api.BaseRepository
import io.reactivex.Observable
import io.reactivex.Single

class MainMessageRepository : BaseRepository() {
    suspend fun getAllUser(): List<UserEntity> {
        return DBManager.userDao.getAll()
    }

    fun getAllUser2(): Observable<List<UserEntity>> {
        return DBManager.userDao.getAll2()
    }

    fun getAllUser3(): Single<List<UserEntity>> {
        return DBManager.userDao.getAll3()
    }

    fun deleteUser(list: List<UserEntity>) {
        for (user in list) {
            user.delete()
        }
    }

    fun update(list: List<UserEntity>) {
        for (user in list) {
            user.update()
        }
    }

    fun createUser(user: UserEntity) {
        user.save()
    }

    fun getUser(name: String): UserEntity? {
        return DBManager.userDao.getUser(name)
    }
}