package com.dyp1016.okr.model.repository

import com.dyp1016.okr.model.api.BaseRepository
import com.dyp1016.qvmvvm.core.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

class TestNetworkRequestRepository : BaseRepository() {


    @ExperimentalCoroutinesApi
    suspend fun test1() = flow {
        kotlinx.coroutines.delay(3000)
        emit(BaseViewModel.UiState(isLoading = false))
    }
        .onStart {
            emit(BaseViewModel.UiState(isLoading = true))
        }
        .flowOn(Dispatchers.IO)
}