package com.robertruzsa.vbpvkmm.android.features.searchoffers.components

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
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.ImportExport
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.RemoveCircleOutline
import androidx.compose.material.icons.outlined.TripOrigin
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.android.ui.components.selectvaluefield.SelectValueField
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route

@Preview
@Composable
fun RouteEditor(
    modifier: Modifier = Modifier,
    route: Route = Route(),
    intermediateLocationsEnabled: Boolean = false,
    onStartLocationClick: (Location) -> Unit = {},
    onAddIntermediateLocationClick: () -> Unit = {},
    onIntermediateLocationClick: (Int, Location) -> Unit = { _, _ -> },
    onRemoveIntermediateLocationClick: (Location) -> Unit = {},
    onEndLocationClick: (Location) -> Unit = {},
    onSwitchLocationsClick: () -> Unit = {}
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
                Row {
                    SelectValueField(
                        modifier = Modifier.weight(1f),
                        label = "Indulás helye",
                        value = route.startLocation.name,
                        startIcon = Icons.Outlined.TripOrigin,
                        isValueSelected = route.startLocation.name.isNotEmpty(),
                        onClick = {
                            onStartLocationClick(route.startLocation)
                        }
                    )
                    if (intermediateLocationsEnabled && route.startOrEndFilled) {
                        IconButton(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(LocalSpacing.current.spacing4dp),
                            onClick = onAddIntermediateLocationClick
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.AddCircleOutline,
                                tint = MaterialTheme.colors.primary,
                                contentDescription = null
                            )
                        }
                    }
                }

                Divider(
                    color = MaterialTheme.colors.background
                )

                route.intermediateLocations.forEachIndexed { index, location ->
                    Row {
                        SelectValueField(
                            modifier = Modifier.weight(1f),
                            label = "Megálló",
                            value = location.name,
                            startIcon = Icons.Outlined.Circle,
                            isValueSelected = location.name.isNotEmpty(),
                            onClick = {
                                onIntermediateLocationClick(index, location)
                            }
                        )
                        IconButton(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(LocalSpacing.current.spacing4dp),
                            onClick = {
                                onRemoveIntermediateLocationClick(location)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.RemoveCircleOutline,
                                tint = MaterialTheme.colors.primary,
                                contentDescription = null
                            )
                        }
                    }

                    Divider(
                        color = MaterialTheme.colors.background
                    )
                }

                Row {
                    SelectValueField(
                        modifier = Modifier.weight(1f),
                        label = "Érkezés helye",
                        value = route.endLocation.name,
                        startIcon = Icons.Outlined.Place,
                        isValueSelected = route.endLocation.name.isNotEmpty(),
                        onClick = {
                            onEndLocationClick(route.endLocation)
                        }
                    )
                    if (intermediateLocationsEnabled && route.startOrEndFilled) {
                        IconButton(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(LocalSpacing.current.spacing4dp),
                            onClick = onSwitchLocationsClick
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ImportExport,
                                tint = MaterialTheme.colors.secondary,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
            if (!intermediateLocationsEnabled && route.startOrEndFilled) {
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
