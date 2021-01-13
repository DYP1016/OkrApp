package com.dyp1016.okr.ui.tab.message

import androidx.lifecycle.MutableLiveData
import com.dyp1016.okr.base.BaseViewModel
import com.dyp1016.okr.model.repository.MainMessageRepository
import com.dyp1016.qvmvvm.core.base.QvResult
import com.dyp1016.qvmvvm.core.base.RET_SUCCESS

class MainMessageViewModel(private val repository: MainMessageRepository) : BaseViewModel() {
    val testResult: MutableLiveData<QvResult<String>> = MutableLiveData()

    fun test1() {
        runAsyncTask {
            repository.test1 {
                showOrHideLoading(false)
                showResult(RET_SUCCESS)
            }
        }
    }

    fun test2() {
        launchOnUI {
            showOrHideLoading(true)
            testResult.postValue(repository.test2())
            showOrHideLoading(false)
        }
    }
}