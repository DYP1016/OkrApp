package com.dyp1016.qvmvvm.core.base

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast

const val RET_SUCCESS = 0
const val RET_FAIL = -2

private val handler = Handler(Looper.getMainLooper())

fun logD(info: String) {
    Log.d(generateTag(getCallerStackTraceElement()), info)
}

fun logI(info: String, tag: String = generateTag(getCallerStackTraceElement())) {
    Log.i(tag, info)
}

fun logE(info: String, tag: String = generateTag(getCallerStackTraceElement())) {
    Log.e(tag, info)
}

fun logE(throwable: Throwable) {
    for (element in throwable.stackTrace) {
        logE("Error", element.toString())
    }
}

fun logTrace(info: String = "") {
    val stack = Thread.currentThread().stackTrace
    for (i in stack.indices) {
        if (i < 4) {
            continue
        }
        val fullClassName = stack[i].className
        val className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1)
        logI(
            "Qv_trace $info",
            fullClassName + ":" + stack[i].methodName + "(" + className + ".java:" + stack[i].lineNumber + ")"
        )
    }
}

fun getCallerStackTraceElement(): StackTraceElement {
    return Thread.currentThread().stackTrace[4]
}

fun showToast(info: String) {
    handler.post {
        Toast.makeText(BaseApp.context, info, Toast.LENGTH_SHORT).show()
    }
}

fun showToastL(info: String) {
    handler.post {
        Toast.makeText(BaseApp.context, info, Toast.LENGTH_LONG).show()
    }
}

fun Int.retSuccess(): Boolean {
    return this == RET_SUCCESS
}

data class QvResult<T>(var code: Int, var result: T?) {
    constructor(code: Int) : this(code, null)

    constructor(result: T) : this(RET_SUCCESS, result)

    fun retSuccess() = code == RET_SUCCESS
}

typealias loadListener<T> = QvResult<T>.() -> Unit

typealias simpleLoadListener = Int.() -> Unit

interface LoadListener<T> {
    fun onResult(result: QvResult<T>)
}

interface SimpleLoadListener {
    fun onResult(code: Int)
}

private fun generateTag(caller: StackTraceElement): String {
    var tag = "%s.%s(L:%d)"
    var callerClazzName = caller.className
    callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1)
    tag = String.format(tag, callerClazzName, caller.methodName, caller.lineNumber)
    return tag
}