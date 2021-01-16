package com.dyp1016.okr.ui.tab.setting

import com.dyp1016.okr.base.BaseViewModel
import com.dyp1016.okr.model.repository.MainSettingsRepository
import com.dyp1016.qvmvvm.core.base.showToastL

class MainSettingsViewModel(val repository: MainSettingsRepository) : BaseViewModel() {

    fun test() {
        showToastL("test")
    }
}