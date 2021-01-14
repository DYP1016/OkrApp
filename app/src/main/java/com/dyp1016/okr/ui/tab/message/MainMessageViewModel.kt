package com.dyp1016.okr.ui.tab.message

import androidx.lifecycle.MutableLiveData
import com.dyp1016.okr.base.BaseViewModel
import com.dyp1016.okr.database.entity.UserEntity
import com.dyp1016.okr.model.repository.MainMessageRepository
import com.dyp1016.qvmvvm.core.base.QvResult
import com.dyp1016.qvmvvm.core.base.logE
import com.dyp1016.qvmvvm.core.base.logI

class MainMessageViewModel(private val repository: MainMessageRepository) : BaseViewModel() {
    val testResult: MutableLiveData<QvResult<String>> = MutableLiveData()
    val userList: MutableLiveData<List<UserEntity>> = MutableLiveData()

    fun getAll() {
        showOrHideLoading(true)
        launchOnUI {
            val info = repository.getAllUser()
            for (user in info) {
                logI(user.toString(), "user")
            }
            showOrHideLoading(false)
        }
    }

    fun createUser() {
        val num = (1..5000).random()
        val user = UserEntity(0L, "user_$num", num, if (num % 2 == 0) 0 else 1)
        repository.createUser(user)
        logI("create user: $user")
    }

    fun updateFirstUser() {
        showOrHideLoading(true)
        launchOnUI {
            val list = repository.getAllUser()
            if (list.isNotEmpty()) {
                val num = (1..5000).random()
                val user = list[0]
                logI("update user, old = ${user.age} ,new = $num")
                user.age = num
                repository.update(listOf(user))
            } else {
                logI("user list is empty")
            }

            showOrHideLoading(false)
        }
    }

    fun deleteFirstUser() {
        showOrHideLoading(true)
        launchOnUI {
            val list = repository.getAllUser()
            if (list.isNotEmpty()) {
                val user = list[0]
                logI("delete user: $user")
                repository.deleteUser(listOf(user))
            } else {
                logI("user list is empty")
            }

            showOrHideLoading(false)
        }
    }

    fun getUser(name: String) {
        val user = repository.getUser(name)
        logE("get user: $user")
    }
}