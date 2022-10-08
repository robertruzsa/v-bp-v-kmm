package com.robertruzsa.vbpvkmm.android.features.createoffer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Offer
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route
import com.robertruzsa.vbpvkmm.features.offers.domain.model.User
import com.robertruzsa.vbpvkmm.features.offers.domain.repository.RideOfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateOfferViewModel @Inject constructor(
    private val offerRepository: RideOfferRepository
) : ViewModel() {

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
