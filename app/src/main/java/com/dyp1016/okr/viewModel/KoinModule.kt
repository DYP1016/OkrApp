package com.dyp1016.okr.viewModel

import com.dyp1016.okr.model.repository.MainRepository
import com.dyp1016.okr.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
    single { MainRepository() }
}

val appModule = listOf(viewModelModule, repositoryModule)