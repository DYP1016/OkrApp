package com.dyp1016.okr.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dyp1016.okr.database.dao.UserDao
import com.dyp1016.qvmvvm.core.base.KtxBaseApp

object DBManager {
    private val db by lazy {
        Room.databaseBuilder(
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
            .addMigrations(migration_2_3, migration_4_5)
//            .fallbackToDestructiveMigration() //迁移数据发生错误时, 将会重新创建数据库
            .build()
    }

    val userDao: UserDao
        get() = db.userDao()

    private val migration_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE TB_USER ADD COLUMN `info` TEXT")
        }
    }

    private val migration_4_5 = object : Migration(4, 5) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `tb_test` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `age` INTEGER NOT NULL, `sex` INTEGER NOT NULL, `info` TEXT)")
        }
    }
}