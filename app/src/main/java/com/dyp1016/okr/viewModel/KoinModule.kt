package com.dyp1016.okr.viewModel

import com.dyp1016.okr.model.repository.MainRepository
import com.dyp1016.okr.model.repository.TestNetworkRequestRepository
import com.dyp1016.okr.ui.MainViewModel
import com.dyp1016.test.ui.TestNetworkRequestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { TestNetworkRequestViewModel(get()) }
}

val repositoryModule = module {
    single { MainRepository() }
    single { TestNetworkRequestRepository() }
}

val appModule = listOf(viewModelModule, repositoryModule)