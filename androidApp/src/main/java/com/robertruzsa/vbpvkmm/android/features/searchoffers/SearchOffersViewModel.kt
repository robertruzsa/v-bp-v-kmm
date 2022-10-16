package com.robertruzsa.vbpvkmm.android.features.searchoffers

import androidx.lifecycle.ViewModel
import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import com.robertruzsa.vbpvkmm.common.util.JsonUtil
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationInfo
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.OfferQuery
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.datetime.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class SearchOffersViewModel @Inject constructor() : ViewModel() {

    private val _route = MutableStateFlow(Route())
    val route = _route.asStateFlow()

    private val _date = MutableStateFlow(DateTimeUtil.now())
    val date = _date.asStateFlow()

    val formattedDate: String
        get() = DateTimeUtil.humanizeDate(_date.value)

    fun updateRoute(locationType: LocationInfo) {
        when (locationType.type) {
            LocationType.START ->
                _route.value = _route.value.copy(startLocation = locationType.location)
            LocationType.END ->
                _route.value = _route.value.copy(endLocation = locationType.location)
            LocationType.INTERMEDIATE -> Unit
        }
    }

    fun switchLocations() {
        val currentStartLocation = _route.value.startLocation
        val currentEndLocation = _route.value.endLocation
        _route.value = route.value.copy(
            startLocation = currentEndLocation,
            endLocation = currentStartLocation
        )
    }

    fun updateDate(date: LocalDateTime) {
        _date.value = date
    }

    fun getOfferQuery() = OfferQuery(
        route = _route.value,
        dateOfTravel = _date.value
    )

    fun getOfferQueryAsJsonString(): String = JsonUtil.toJsonString(
        OfferQuery(
            route = _route.value,
            dateOfTravel = _date.value
        )
    )
}
