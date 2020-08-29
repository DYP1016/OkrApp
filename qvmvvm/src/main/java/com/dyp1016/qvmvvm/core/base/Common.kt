package com.dyp1016.qvmvvm.core.base

import android.content.Context
import android.content.Intent

inline fun <reified T> startTargetActivity(
    context: Context, block: Intent.() -> Unit = {

    }
) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}