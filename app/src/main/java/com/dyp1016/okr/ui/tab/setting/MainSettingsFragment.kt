package com.dyp1016.okr.ui.tab.setting

import android.os.Bundle
import androidx.preference.Preference
import com.dyp1016.okr.R
import com.dyp1016.okr.base.BaseVMPreferenceFragment
import com.dyp1016.qvmvvm.core.base.logE
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainSettingsFragment : BaseVMPreferenceFragment() {
    private val viewModel by viewModel<MainSettingsViewModel>()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        initViewModel(viewModel, this)

        findPreference<Preference>("sync_button")?.apply {
            setOnPreferenceClickListener {
                viewModel.test()
                true
            }
        }
    }

    override fun onResume() {
        super.onResume()
        logE("onResume")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        logE("$hidden", "onHiddenChanged")
    }

    override fun onPause() {
        super.onPause()
        logE("onPause")
    }

    override fun onStart() {
        super.onStart()
        logE("onStart")
    }

    override fun onStop() {
        super.onStop()
        logE("onStop")
    }
}