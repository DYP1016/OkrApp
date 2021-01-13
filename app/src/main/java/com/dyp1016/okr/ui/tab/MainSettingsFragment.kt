package com.dyp1016.okr.ui.tab

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.dyp1016.okr.R
import com.dyp1016.qvmvvm.core.base.logE

class MainSettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
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