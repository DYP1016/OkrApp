package com.dyp1016.okr.ui.main

import androidx.lifecycle.MutableLiveData
import com.dyp1016.okr.base.BaseViewModel
import com.dyp1016.okr.bean.User
import com.dyp1016.okr.model.repository.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

open class MainViewModel(private val repository: MainRepository) : BaseViewModel() {
    var userData: MutableLiveData<User> = MutableLiveData()

    init {
        refresh()
    }

    fun refresh() {
        val user = User("DYP", true, (1..50).random())
        userData.postValue(user)
    }

    @ExperimentalCoroutinesApi
    fun test1() {
        launchOnUI {
            repository.test1()
                .collect { emitUiState(it) }
        }
    }

    fun onClick() {
        refresh()
    }
}