package com.dyp1016.okr.model.repository

import com.dyp1016.okr.model.api.BaseRepository
import com.dyp1016.qvmvvm.core.base.KtxBaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

class MainRepository : BaseRepository() {


    @ExperimentalCoroutinesApi
    suspend fun test1() = flow {
        kotlinx.coroutines.delay(3000)
        emit(KtxBaseViewModel.UiState())
    }
        .onStart {
            emit(KtxBaseViewModel.UiState())
        }
        .flowOn(Dispatchers.IO)
}