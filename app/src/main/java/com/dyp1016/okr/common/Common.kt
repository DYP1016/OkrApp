package com.dyp1016.okr.common

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.dyp1016.okr.R
import com.dyp1016.qvmvvm.core.base.KtxBaseApp
import com.dyp1016.qvmvvm.core.base.showToast

fun AppCompatActivity.showCommonDialog(
    info: String,
    title: String? = null,
    confirm: String? = null,
    onConfirm: (() -> Unit)? = null
) {
    AlertDialog.Builder(this).apply {
        setMessage(info)
        if (title != null) {
            setTitle(title)
        }

        setPositiveButton(confirm ?: KtxBaseApp.context.getText(R.string.confirm)) { _, _ ->
            if (onConfirm != null) {
                onConfirm()
            }
        }

        show()
    }
}

/**
 * 显示响应结果
 */
fun showResult(code: Int) {
    showToast("Fail, code: $code")
}

fun showSuccess(code: Int) {
    showToast(KtxBaseApp.context.getString(R.string.key_success))
}

fun showFail(code: Int) {
    showToast(KtxBaseApp.context.getString(R.string.key_fail) + ": " + code)
}