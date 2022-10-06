package com.robertruzsa.vbpvkmm.android.features.search

import androidx.lifecycle.ViewModel
import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import com.robertruzsa.vbpvkmm.common.util.JsonUtil
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route
import com.robertruzsa.vbpvkmm.features.search.domain.LocationType
import com.robertruzsa.vbpvkmm.features.search.domain.OfferQuery
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

    fun updateRoute(locationType: LocationType) {
        when (locationType) {
            is LocationType.Start ->
                _route.value = _route.value.copy(startLocation = locationType.value)
            is LocationType.End ->
                _route.value = _route.value.copy(endLocation = locationType.value)
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
