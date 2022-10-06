package com.robertruzsa.vbpvkmm.features.offers.domain.model

import com.robertruzsa.vbpvkmm.common.util.DateTimeUtil
import kotlinx.datetime.LocalDateTime

data class OfferFilter(
    val route: Route = Route(),
    val dateOfTravel: LocalDateTime = DateTimeUtil.now()
)
