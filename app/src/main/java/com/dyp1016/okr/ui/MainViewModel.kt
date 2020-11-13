package com.dyp1016.okr.ui

import androidx.lifecycle.MutableLiveData
import com.dyp1016.okr.bean.User
import com.dyp1016.okr.model.repository.MainRepository
import com.dyp1016.qvmvvm.core.base.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

open class MainViewModel(private val repository: MainRepository) : BaseViewModel() {
    var userData: MutableLiveData<User> = MutableLiveData()

    private val _uiState = MutableLiveData<UiState<Int>>()
    val uiState: MutableLiveData<UiState<Int>> get() = _uiState

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
                .collect { _uiState.postValue(it) }
        }
    }

    fun onClick() {
        refresh()
    }
}