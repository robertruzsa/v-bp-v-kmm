package com.robertruzsa.vbpvkmm.android.features.searchoffers

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
import com.robertruzsa.vbpvkmm.android.features.searchoffers.components.SearchPanel
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.android.ui.components.Spacing
import com.robertruzsa.vbpvkmm.android.ui.components.TopBar
import com.robertruzsa.vbpvkmm.android.util.NavUtil.getCurrentStateHandleValue
import com.robertruzsa.vbpvkmm.android.util.NavUtil.setCurrentStateHandleValue
import com.robertruzsa.vbpvkmm.common.domain.Argument
import com.robertruzsa.vbpvkmm.common.domain.Screen
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationInfo
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationType
import kotlinx.datetime.LocalDateTime

@Composable
fun SearchOffersScreen(
    navController: NavController,
    viewModel: SearchOffersViewModel = hiltViewModel()
) {

    val route by viewModel.route.collectAsState()

    val date by viewModel.date.collectAsState()

    LaunchedEffect(Unit) {
        val locationFromSearchScreen =
            navController.getCurrentStateHandleValue<LocationInfo>(Argument.Location.key)
        locationFromSearchScreen?.let { location ->
            viewModel.updateRoute(location)
        }
        val selectedDate =
            navController.getCurrentStateHandleValue<LocalDateTime>(Argument.Date.key)
        selectedDate?.let {
            viewModel.updateDate(it)
        }
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
                navController.setCurrentStateHandleValue(
                    key = Argument.Location.key,
                    value = LocationInfo(it, LocationType.START)
                )
                navController.navigate(Screen.SearchLocation.route)
            },
            onEndLocationClick = {
                navController.setCurrentStateHandleValue(
                    key = Argument.Location.key,
                    value = LocationInfo(it, LocationType.END)
                )
                navController.navigate(Screen.SearchLocation.route)
            },
            onSwitchLocationsClick = {
                viewModel.switchLocations()
            },
            date = viewModel.formattedDate,
            onDateClick = {
                navController.setCurrentStateHandleValue(
                    key = Argument.Date.key,
                    value = date
                )
                navController.navigate(Screen.Calendar.route)
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
