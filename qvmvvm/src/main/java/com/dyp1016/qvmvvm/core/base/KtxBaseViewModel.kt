package com.dyp1016.qvmvvm.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class KtxBaseViewModel : ViewModel() {
    private var uiStateInner = MutableLiveData<UiState>()
    val uiState: MutableLiveData<UiState> get() = uiStateInner

    open class UiState(
        val isLoading: Boolean? = false,
        val isRefresh: Boolean? = false,
        val isError: Int? = null,
        val isSuccess: Int? = null
    )

    val mException: MutableLiveData<Throwable> = MutableLiveData()

    inline fun runAsyncTask(isShowLoading: Boolean = true, block: () -> Unit) {
        if (isShowLoading) {
            showOrHideLoading(true)
        }

        block()

        if (isShowLoading) {
            showOrHideLoading(false)
        }
    }

    fun showOrHideLoading(isShow: Boolean) {
        emitUiState(UiState(isLoading = isShow))
    }

    fun showOrHideRefresh(isShow: Boolean) {
        emitUiState(UiState(isRefresh = isShow))
    }

    fun showResult(code: Int) {
        if (code.retSuccess()) {
            emitUiState(UiState(isSuccess = RET_SUCCESS))
        } else {
            emitUiState(UiState(isError = code))
        }
    }

    fun showResult(result: QvResult<*>) {
        if (result.retSuccess()) {
            emitUiState(UiState(isSuccess = RET_SUCCESS))
        } else {
            emitUiState(UiState(isError = result.code))
        }
    }

    fun emitUiState(state: UiState) {
        uiStateInner.postValue(state)
    }

    fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }

    suspend fun <T> launchOnIO(block: suspend CoroutineScope.() -> T) {
        withContext(Dispatchers.IO) {
            block
        }
    }
}