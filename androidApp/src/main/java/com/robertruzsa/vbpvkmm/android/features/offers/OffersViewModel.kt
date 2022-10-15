package com.robertruzsa.vbpvkmm.android.features.offers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Offer
import com.robertruzsa.vbpvkmm.features.offers.domain.repository.RideOfferRepository
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.OfferQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class OffersViewModel @Inject constructor(
    private val offersRepository: RideOfferRepository
) : ViewModel() {
    private val _posts = MutableStateFlow<List<Offer>>(emptyList())
    val offers = _posts.asStateFlow()

    private val _date = MutableStateFlow(DateTimeUtil.now())
    val date = _date.asStateFlow()

    private var filter: OfferQuery? = null

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            _posts.value = offersRepository.getAllRideOffers()
        }
    }

    fun getScreenTitle(): String {
        val route = filter?.route
        val defaultTitle = "Hirdetések"
        return when {
            route == null -> defaultTitle
            route.startLocation.name.isBlank() -> defaultTitle
            route.endLocation.name.isBlank() -> defaultTitle
            else -> "${route.startLocation.name} ➝ ${route.endLocation.name}"
        }
    }

    fun onDateSelected(date: LocalDateTime) {
        _date.value = date
    }

    fun onFilterChanged(filter: OfferQuery) {
        this.filter = filter
    }

    fun getSelectableDates(): List<LocalDateTime> {
        val startDate = filter?.dateOfTravel ?: DateTimeUtil.now()
        return DateTimeUtil.getSelectableDates(startDate)
    }

    companion object {
        const val NUMBER_OF_SELECTABLE_DATES = 14
    }
}
