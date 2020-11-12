package com.dyp1016.qvmvvm.core.base

import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

inline fun <reified T> startTargetActivity(
    context: Context, block: Intent.() -> Unit = {

    }
) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}

fun AppCompatActivity.hideSoftInput() {
    val inputMethodManager =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}