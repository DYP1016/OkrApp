package com.dyp1016.test.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dyp1016.okr.base.BaseViewModel
import com.dyp1016.qvmvvm.core.base.QvResult
import com.dyp1016.test.repository.TestNetworkRequestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestNetworkRequestViewModel(private val repository: TestNetworkRequestRepository) :
    BaseViewModel() {
    private var _uiModel = MutableLiveData<UiModel>()
    val uiModel: MutableLiveData<UiModel> get() = _uiModel

    class UiModel(
        val result: String? = null,
    )

    fun test1() {
        runAsyncTask {
            viewModelScope.launch(Dispatchers.Main) {
                val ret = repository.test1(1)
                dealWithResult(ret)
            }
        }
    }

    fun test2() {
        runAsyncTask {
            repository.test2 {
                dealWithResult(it)
            }
        }
    }

    fun test3() {
        runAsyncTask {
            viewModelScope.launch {
                dealWithResult(repository.test3())
            }
        }
    }

    private fun emitUiState(state: UiModel) {
        _uiModel.postValue(state)
    }

    private fun <T> dealWithResult(result: QvResult<T>) {
        showOrHideLoading(false)
        if (result.retSuccess()) {
            emitUiState(UiModel(result.result.toString()))
        } else {
            showResult(result)
        }
    }
}