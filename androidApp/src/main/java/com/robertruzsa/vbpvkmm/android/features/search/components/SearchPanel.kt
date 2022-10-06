package com.robertruzsa.vbpvkmm.android.features.search.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Event
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.robertruzsa.vbpvkmm.android.features.search.RouteEditor
import com.robertruzsa.vbpvkmm.android.ui.components.BaseButton
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.android.ui.components.selectvaluefield.SelectValueField
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route

@Composable
fun SearchPanel(
    modifier: Modifier = Modifier,
    route: Route = Route(),
    date: String = "Ma",
    onStartLocationClick: (Location) -> Unit = {},
    onEndLocationClick: (Location) -> Unit = {},
    onSwitchLocationsClick: () -> Unit,
    onDateClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        RouteEditor(
            modifier = Modifier.padding(top = LocalSpacing.current.spacing16dp),
            route = route,
            onStartLocationClick = { startLocation ->
                onStartLocationClick(startLocation)
            },
            onEndLocationClick = { endLocation ->
                onEndLocationClick(endLocation)
            },
            onSwitchLocationsClick = {
                onSwitchLocationsClick()
            }
        )

        SelectValueField(
            modifier = Modifier.padding(top = LocalSpacing.current.spacing16dp),
            label = "Utazás dátuma",
            value = date,
            startIcon = Icons.Outlined.Event,
            isValueSelected = true,
            onClick = {
                onDateClick.invoke()
            }
        )

        BaseButton(
            text = "Keresés",
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(LocalSpacing.current.spacing16dp),
            onClick = onSearchClick
        )
    }
}
