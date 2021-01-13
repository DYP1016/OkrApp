package com.dyp1016.okr.viewModel

import com.dyp1016.okr.model.repository.MainMessageRepository
import com.dyp1016.okr.model.repository.MainRepository
import com.dyp1016.okr.ui.main.MainViewModel
import com.dyp1016.okr.ui.tab.message.MainMessageViewModel
import com.dyp1016.test.repository.TestNetworkRequestRepository
import com.dyp1016.test.ui.TestNetworkRequestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { TestNetworkRequestViewModel(get()) }
    viewModel { MainMessageViewModel(get()) }
}

val repositoryModule = module {
    single { MainRepository() }
    single { TestNetworkRequestRepository() }
    single { MainMessageRepository() }
}

val appModule = listOf(viewModelModule, repositoryModule)