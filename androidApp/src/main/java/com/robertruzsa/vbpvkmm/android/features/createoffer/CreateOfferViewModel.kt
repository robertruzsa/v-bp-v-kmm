package com.robertruzsa.vbpvkmm.android.features.createoffer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Offer
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route
import com.robertruzsa.vbpvkmm.features.offers.domain.model.User
import com.robertruzsa.vbpvkmm.features.offers.domain.repository.RideOfferRepository
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationInfo
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CreateOfferViewModel @Inject constructor(
    private val offerRepository: RideOfferRepository
) : ViewModel() {

    private val _route = MutableStateFlow(Route())
    val route = _route.asStateFlow()

    private val _date = MutableStateFlow(DateTimeUtil.now())
    val date = _date.asStateFlow()

    val numberOfFreeSeats: Int = 3

    val formattedDate: String
        get() = DateTimeUtil.humanizeDate(_date.value)

    fun switchLocations() {
        val currentStartLocation = _route.value.startLocation
        val currentEndLocation = _route.value.endLocation
        _route.value = route.value.copy(
            startLocation = currentEndLocation,
            endLocation = currentStartLocation
        )
    }

    fun updateRoute(locationInfo: LocationInfo) {
        when (locationInfo.type) {
            LocationType.START ->
                _route.value = _route.value.copy(startLocation = locationInfo.location)
            LocationType.END ->
                _route.value = _route.value.copy(endLocation = locationInfo.location)
            LocationType.INTERMEDIATE -> {
                if (locationInfo.isIntermediateAddition) {
                    addIntermediateLocation(locationInfo.location)
                } else {
                    editIntermediateLocation(locationInfo)
                }
            }
        }
    }

    private fun addIntermediateLocation(location: Location) {
        val currentIntermediateStops = _route.value.intermediateLocations.toMutableList()
        currentIntermediateStops.add(location)
        _route.value = _route.value.copy(
            intermediateLocations = currentIntermediateStops
        )
    }

    private fun editIntermediateLocation(locationInfo: LocationInfo) {
        val currentIntermediateStops = _route.value.intermediateLocations.toMutableList()
        currentIntermediateStops[locationInfo.id] = locationInfo.location
        _route.value = _route.value.copy(
            intermediateLocations = currentIntermediateStops
        )
    }

    fun removeIntermediateLocation(location: Location) {
        val currentIntermediateStops = _route.value.intermediateLocations.toMutableList()
        currentIntermediateStops.remove(location)
        _route.value = _route.value.copy(
            intermediateLocations = currentIntermediateStops
        )
    }

    fun updateDate(date: LocalDateTime) {
        _date.value = date
    }

    fun createOffer() = viewModelScope.launch {
        offerRepository.createOffer(
            Offer(
                user = User(),
                route = Route(
                    startLocation = Location("Torda"),
                    endLocation = Location("Basaid")
                ),
                dateOfTravel = DateTimeUtil.now(),
                dateOfPost = DateTimeUtil.now(),
                numberOfSeats = 1,
                priceInHuf = 6000
            )
        )
    }
}
