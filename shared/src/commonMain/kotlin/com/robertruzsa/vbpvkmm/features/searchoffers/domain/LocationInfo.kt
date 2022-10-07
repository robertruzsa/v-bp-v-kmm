package com.robertruzsa.vbpvkmm.features.searchoffers.domain

import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import kotlinx.serialization.Serializable

@Serializable
data class LocationInfo(
    var location: Location,
    val type: LocationType
)
