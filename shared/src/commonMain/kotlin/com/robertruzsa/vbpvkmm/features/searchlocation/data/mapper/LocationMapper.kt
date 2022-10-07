package com.robertruzsa.vbpvkmm.features.searchlocation.data.mapper

import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.searchlocation.data.dto.LocationQueryResultResponse

fun LocationQueryResultResponse.toDomainModel(): List<Location> =
    locations.map { Location(it.name) }
