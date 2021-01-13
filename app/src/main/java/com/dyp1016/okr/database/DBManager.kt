package com.dyp1016.okr.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dyp1016.okr.database.dao.UserDao
import com.dyp1016.qvmvvm.core.base.KtxBaseApp

object DBManager {
    private val db = Room.databaseBuilder(
        KtxBaseApp.context.applicationContext,
        AppDatabase::class.java, "okr_db"
    )
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                //第一次创建数据库且创建表完成之后调用
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                //当数据库被打开时调用
            }
        })
        .allowMainThreadQueries()   //允许主线程查询数据
//        .addMigrations()
        .fallbackToDestructiveMigration() //迁移数据发生错误时, 将会重新创建数据库
        .build()

    val userDao: UserDao
        get() = db.userDao()
}