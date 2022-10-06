package com.robertruzsa.vbpvkmm.common.domain

sealed class Argument(val key: String) {
    object Location : Argument("location")
    object Date : Argument("date")
    object OfferFilters : Argument("offer_filters")
}
