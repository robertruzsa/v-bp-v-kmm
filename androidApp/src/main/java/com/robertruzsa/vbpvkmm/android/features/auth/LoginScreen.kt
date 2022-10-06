package com.robertruzsa.vbpvkmm.android.features.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.robertruzsa.vbpvkmm.common.domain.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val isLoggedIn by viewModel.isLoggedIn.collectAsState()
    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn) {
            navController.navigate(Screen.Posts.route) {
                popUpTo(Screen.Login.route) {
                    inclusive = true
                }
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(factory = { context ->
            LoginButton(context).apply {
                registerCallback(
                    viewModel.callbackManager,
                    object : FacebookCallback<LoginResult> {
                        override fun onCancel() {
                            viewModel.onCancel()
                        }

                        override fun onError(error: FacebookException) {
                            viewModel.onError(error)
                        }

                        override fun onSuccess(result: LoginResult) {
                            viewModel.onSuccess()
                        }
                    }
                )
            }
        })
    }
}
