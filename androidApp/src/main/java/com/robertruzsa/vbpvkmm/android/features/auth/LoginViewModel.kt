package com.robertruzsa.vbpvkmm.android.features.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    val callbackManager = CallbackManager.Factory.create()

    private val _isLoggedIn = MutableStateFlow(isLoggedIn())
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    private fun isLoggedIn() = AccessToken.getCurrentAccessToken().let {
        it != null && !it.isExpired
    }

    fun onSuccess() {
        _isLoggedIn.value = isLoggedIn()
    }

    fun onError(e: FacebookException) {
        e.printStackTrace()
    }

    fun onCancel() {
        Log.d(TAG, "login cancelled")
    }

    companion object {
        private const val TAG = "facebook login"
    }
}
