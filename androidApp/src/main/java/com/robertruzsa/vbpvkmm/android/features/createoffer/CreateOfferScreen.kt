package com.robertruzsa.vbpvkmm.android.features.createoffer

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CreateOfferScreen(
    navController: NavController,
    viewModel: CreateOfferViewModel = hiltViewModel()
) {
    Button(
        onClick = {
            viewModel.createOffer()
        }
    ) {
        Text("Küldés")
    }
}
