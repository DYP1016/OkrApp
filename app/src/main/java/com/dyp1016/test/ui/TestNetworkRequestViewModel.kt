package com.dyp1016.test.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dyp1016.qvmvvm.core.base.BaseViewModel
import com.dyp1016.test.repository.TestNetworkRequestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestNetworkRequestViewModel(private val repository: TestNetworkRequestRepository) :
    BaseViewModel() {
    private var _uiModel = MutableLiveData<UiModel>()
    val uiModel: MutableLiveData<UiModel> get() = _uiModel

    class UiModel(
        val result: String? = null,
        isLoading: Boolean = false,
        isRefresh: Boolean = false,
        isError: Int? = null
    ) : BaseViewModel.UiState(isLoading, isRefresh, isError)

    fun test1() {
        emitUiState(UiModel(isLoading = true))
        viewModelScope.launch(Dispatchers.Main) {
            val ret = repository.test1(1)

            if (ret.retSuccess()) {
                emitUiState(UiModel(isLoading = false, result = ret.result.toString()))
            } else {
                emitUiState(UiModel(isLoading = false, isError = ret.code))
            }
        }
    }

    private fun emitUiState(state: UiModel) {
        _uiModel.postValue(state)
    }
}