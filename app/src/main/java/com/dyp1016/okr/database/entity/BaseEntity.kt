package com.dyp1016.okr.database.entity

abstract class BaseEntity {
    abstract fun save()

    abstract fun update()

    abstract fun delete()
}