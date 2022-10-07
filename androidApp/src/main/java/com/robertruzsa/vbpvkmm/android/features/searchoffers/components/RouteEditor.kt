package com.robertruzsa.vbpvkmm.android.features.searchoffers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ImportExport
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.TripOrigin
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.android.ui.components.selectvaluefield.SelectValueField
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route

@Composable
fun RouteEditor(
    modifier: Modifier = Modifier,
    route: Route = Route(),
    onStartLocationClick: (Location) -> Unit = {},
    onEndLocationClick: (Location) -> Unit = {},
    onSwitchLocationsClick: () -> Unit

) {
    Card(
        modifier = modifier,
        shape = RectangleShape,
        elevation = 0.dp
    ) {
        Row {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                SelectValueField(
                    label = "Indulás helye",
                    value = route.startLocation.name,
                    startIcon = Icons.Outlined.TripOrigin,
                    isValueSelected = route.startLocation.name.isNotEmpty(),
                    onClick = {
                        onStartLocationClick(route.startLocation)
                    }
                )

                Divider(
                    color = MaterialTheme.colors.background
                )

                SelectValueField(
                    label = "Érkezés helye",
                    value = route.endLocation.name,
                    startIcon = Icons.Outlined.Place,
                    isValueSelected = route.endLocation.name.isNotEmpty(),
                    onClick = {
                        onEndLocationClick(route.endLocation)
                    }
                )
            }

            if (route.startLocation.name.isNotEmpty() || route.endLocation.name.isNotEmpty()) {
                IconButton(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(LocalSpacing.current.spacing4dp),
                    onClick = onSwitchLocationsClick
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = Icons.Outlined.ImportExport,
                        tint = MaterialTheme.colors.secondary,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
