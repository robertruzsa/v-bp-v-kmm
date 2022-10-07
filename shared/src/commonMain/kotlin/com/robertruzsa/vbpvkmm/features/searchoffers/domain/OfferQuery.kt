package com.robertruzsa.vbpvkmm.features.searchoffers.domain

import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class OfferQuery(
    val route: Route = Route(),
    val dateOfTravel: LocalDateTime = DateTimeUtil.now()
)
