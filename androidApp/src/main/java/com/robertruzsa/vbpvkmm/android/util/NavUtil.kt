package com.robertruzsa.vbpvkmm.android.util

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.robertruzsa.vbpvkmm.common.util.JsonUtil

object NavUtil {

    private val NavController.currentSavedStateHandle: SavedStateHandle?
        get() = this.currentBackStackEntry?.savedStateHandle

    private val NavController.previousSavedStateHandle: SavedStateHandle?
        get() = this.previousBackStackEntry?.savedStateHandle

    fun <T> NavController.setValueForCurrentSavedStateHandle(key: String, value: T?) {
        currentSavedStateHandle?.set(key, value)
    }

    fun <T> NavController.setValueForPreviousSavedStateHandle(key: String, value: T?) {
        previousSavedStateHandle?.set(key, value)
    }

    fun <T> NavController.getValueFromCurrentSavedStateHandle(key: String): T? =
        currentSavedStateHandle?.get<T>(key)

    fun <T> NavController.getValueFromPreviousSavedStateHandle(key: String): T? =
        previousSavedStateHandle?.get<T>(key)

    inline fun <reified T> NavController.setCurrentStateHandleValue(key: String, value: T?) {
        setValueForCurrentSavedStateHandle(key, JsonUtil.toJsonString(value))
    }

    inline fun <reified T> NavController.setPreviousStateHandleValue(key: String, value: T?) {
        setValueForPreviousSavedStateHandle(key, JsonUtil.toJsonString(value))
    }

    inline fun <reified T> NavController.getCurrentStateHandleValue(key: String): T? =
        getValueFromCurrentSavedStateHandle<T>(key)

    inline fun <reified T> NavController.getPreviousStateHandleValue(key: String): T? {
        val valueString = getValueFromPreviousSavedStateHandle<String>(key) ?: return null
        return JsonUtil.fromJsonString<T>(valueString)
    }
}
