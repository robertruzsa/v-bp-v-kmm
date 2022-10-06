package com.robertruzsa.vbpvkmm.features.search.domain

import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location

sealed class LocationType(open var value: Location) {

    data class Start(override var value: Location) : LocationType(value)

    data class End(override var value: Location) : LocationType(value)
}
