package com.dyp1016.okr.model.repository

import com.dyp1016.okr.database.DBManager
import com.dyp1016.okr.database.entity.UserEntity
import com.dyp1016.okr.model.api.BaseRepository

class MainMessageRepository : BaseRepository() {
    suspend fun getAllUser(): List<UserEntity> {
        return DBManager.userDao.getAll()
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
}