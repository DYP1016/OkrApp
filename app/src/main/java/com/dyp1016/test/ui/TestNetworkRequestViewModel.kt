package com.dyp1016.test.ui

import androidx.lifecycle.MutableLiveData
import com.dyp1016.okr.model.repository.TestNetworkRequestRepository
import com.dyp1016.qvmvvm.core.base.BaseViewModel

class TestNetworkRequestViewModel(repository: TestNetworkRequestRepository) : BaseViewModel() {
    private val _uiModel = MutableLiveData<UiModel>()
    val uiModel: MutableLiveData<UiModel> get() = _uiModel

    class UiModel(
        val result: String? = null
    ) : BaseViewModel.UiState()
}