package com.robertruzsa.vbpvkmm.android.features.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.robertruzsa.vbpvkmm.android.features.search.components.SearchPanel
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.android.ui.components.Spacing
import com.robertruzsa.vbpvkmm.android.ui.components.TopBar
import com.robertruzsa.vbpvkmm.android.util.NavUtil.setCurrentStateHandleValue
import com.robertruzsa.vbpvkmm.common.domain.Argument
import com.robertruzsa.vbpvkmm.common.domain.Screen

@Composable
fun SearchOffersScreen(
    navController: NavController,
    viewModel: SearchOffersViewModel = hiltViewModel()
) {
    // val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle

    val route by viewModel.route.collectAsState()

    val date by viewModel.date.collectAsState()

    LaunchedEffect(Unit) {
        /*val locationFromSearchScreen: LocationType? = savedStateHandle?.get(Argument.Location.key)
        locationFromSearchScreen?.let { location ->
            viewModel.updateRoute(location)
        }
        val selectedDate: LocalDateTime? = savedStateHandle?.get(Argument.Date.key)
        selectedDate?.let {
            viewModel.updateDate(it)
        }*/
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        TopBar(title = "Keresés")
        Spacing(LocalSpacing.current.spacing8dp)
        SearchPanel(
            route = route,
            onStartLocationClick = {
                /*savedStateHandle?.set(
                    key = Argument.Location.key,
                    value = LocationType.Start(it)
                )
                navController.navigate(Screen.SearchLocation.route)*/
            },
            onEndLocationClick = {
                /*savedStateHandle?.set(
                    key = Argument.Location.key,
                    value = LocationType.End(it)
                )
                navController.navigate(Screen.SearchLocation.route)*/
            },
            onSwitchLocationsClick = {
                viewModel.switchLocations()
            },
            date = viewModel.formattedDate,
            onDateClick = {
                /*savedStateHandle?.set(
                    key = Argument.Date.key,
                    value = date
                )
                navController.navigate(Screen.Calendar.route)*/
            },
            onSearchClick = {
                navController.setCurrentStateHandleValue(
                    key = Argument.OfferFilters.key,
                    value = viewModel.getOfferQuery()
                )
                navController.navigate(Screen.Offers.route)
            }
        )
    }
}
