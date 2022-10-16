package com.robertruzsa.vbpvkmm.android.features.createoffer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material.icons.outlined.TimeToLeave
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.robertruzsa.vbpvkmm.android.features.searchoffers.components.RouteEditor
import com.robertruzsa.vbpvkmm.android.ui.components.BaseButton
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.android.ui.components.Spacing
import com.robertruzsa.vbpvkmm.android.ui.components.TopBar
import com.robertruzsa.vbpvkmm.android.ui.components.selectvaluefield.SelectValueField
import com.robertruzsa.vbpvkmm.android.util.NavUtil.getCurrentStateHandleValue
import com.robertruzsa.vbpvkmm.android.util.NavUtil.setCurrentStateHandleValue
import com.robertruzsa.vbpvkmm.common.domain.Argument
import com.robertruzsa.vbpvkmm.common.domain.Screen
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationInfo
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationType
import kotlinx.datetime.LocalDateTime

@Composable
fun CreateOfferScreen(
    navController: NavController,
    viewModel: CreateOfferViewModel = hiltViewModel()
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

    Scaffold(
        topBar = {
            TopBar(title = "Hirdetés")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
        ) {

            Spacing(LocalSpacing.current.spacing8dp)
            RouteEditor(
                modifier = Modifier.padding(top = LocalSpacing.current.spacing16dp),
                route = route,
                intermediateLocationsEnabled = true,
                onStartLocationClick = { startLocation ->
                    navController.setCurrentStateHandleValue(
                        key = Argument.Location.key,
                        value = LocationInfo(startLocation, LocationType.START)
                    )
                    navController.navigate(Screen.SearchLocation.route)
                },
                onAddIntermediateLocationClick = {
                    navController.setCurrentStateHandleValue(
                        key = Argument.Location.key,
                        value = LocationInfo(Location(), LocationType.INTERMEDIATE)
                    )
                    navController.navigate(Screen.SearchLocation.route)
                },
                onIntermediateLocationClick = { index, location ->
                    navController.setCurrentStateHandleValue(
                        key = Argument.Location.key,
                        value = LocationInfo(location, LocationType.INTERMEDIATE, index)
                    )
                    navController.navigate(Screen.SearchLocation.route)
                },
                onRemoveIntermediateLocationClick = { location ->
                    viewModel.removeIntermediateLocation(location)
                },
                onEndLocationClick = { endLocation ->
                    navController.setCurrentStateHandleValue(
                        key = Argument.Location.key,
                        value = LocationInfo(endLocation, LocationType.END)
                    )
                    navController.navigate(Screen.SearchLocation.route)
                },
                onSwitchLocationsClick = {
                    viewModel.switchLocations()
                }
            )

            SelectValueField(
                modifier = Modifier.padding(top = LocalSpacing.current.spacing16dp),
                label = "Utazás dátuma",
                value = viewModel.formattedDate,
                startIcon = Icons.Outlined.Event,
                isValueSelected = true,
                onClick = {
                    navController.setCurrentStateHandleValue(
                        key = Argument.Date.key,
                        value = date
                    )
                    navController.navigate(Screen.Calendar.route)
                }
            )

            SelectValueField(
                modifier = Modifier.padding(top = LocalSpacing.current.spacing16dp),
                label = "Jármű adatok",
                value = viewModel.numberOfFreeSeats.toString(),
                startIcon = Icons.Outlined.TimeToLeave,
                onClick = {
                }
            )
            Divider(
                color = MaterialTheme.colors.background
            )
            SelectValueField(
                label = "Férőhelyek száma",
                value = viewModel.numberOfFreeSeats.toString(),
                startIcon = Icons.Outlined.Group,
                isValueSelected = true,
                onClick = {
                }
            )

            Spacer(modifier = Modifier.height(LocalSpacing.current.spacing16dp))

            SelectValueField(
                label = "Ár",
                value = "3000 Ft",
                startIcon = Icons.Outlined.LocalOffer,
                isValueSelected = true,
                onClick = {
                }
            )

            BaseButton(
                text = "Közzététel",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(LocalSpacing.current.spacing16dp),
                onClick = {
                    // viewModel.createOffer()
                }
            )
        }
    }
}
