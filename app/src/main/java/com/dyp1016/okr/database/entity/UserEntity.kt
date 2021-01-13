package com.dyp1016.okr.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dyp1016.okr.database.DBManager

@Entity(tableName = "tb_user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String,
    var age: Int,
    var sex: Int
) : BaseEntity() {

    override fun save() {
        DBManager.userDao.insert(this)
    }

    override fun update() {
        DBManager.userDao.update(this)
    }

    override fun delete() {
        DBManager.userDao.delete(this)
    }
}