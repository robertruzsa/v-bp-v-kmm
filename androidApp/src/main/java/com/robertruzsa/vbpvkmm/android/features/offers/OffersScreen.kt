package com.robertruzsa.vbpvkmm.android.features.offers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.robertruzsa.vbpvkmm.android.ui.components.TopBar
import com.robertruzsa.vbpvkmm.android.ui.components.horizontaldatepicker.HorizontalDatePicker
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.common.domain.Argument
import com.robertruzsa.vbpvkmm.features.offers.domain.model.OfferFilter

@Composable
fun OffersScreen(
    navController: NavController,
    viewModel: OffersViewModel = hiltViewModel()
) {

    val savedStateHandle = navController.previousBackStackEntry?.savedStateHandle

    LaunchedEffect(Unit) {
        val filters: OfferFilter? = savedStateHandle?.get(Argument.OfferFilters.key)
        filters?.let {
            viewModel.run {
                onFilterChanged(it)
                onDateSelected(it.dateOfTravel)
            }
        }
    }

    val offers by viewModel.offers.collectAsState()

    val selectedDate by viewModel.date.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        TopBar(
            title = viewModel.getScreenTitle(),
            navigationIcon = Icons.Outlined.ArrowBack,
            onNavigationIconClick = {
                navController.navigateUp()
            }
        )
        HorizontalDatePicker(
            selectedDate = selectedDate,
            selectableDates = viewModel.getSelectableDates(),
            onDateClick = {
                viewModel.onDateSelected(it)
            }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(offers) { index, post ->
                Spacer(Modifier.height(LocalSpacing.current.spacing8dp))
                OfferItem(post)
                if (index == offers.lastIndex) {
                    Spacer(Modifier.height(LocalSpacing.current.spacing8dp))
                }
            }
        }
    }
}
