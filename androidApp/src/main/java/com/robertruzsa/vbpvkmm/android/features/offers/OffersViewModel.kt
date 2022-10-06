package com.robertruzsa.vbpvkmm.android.features.offers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertruzsa.vbpvkmm.common.util.DateTimeUtil
import com.robertruzsa.vbpvkmm.common.util.DateTimeUtil.plusDays
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Offer
import com.robertruzsa.vbpvkmm.features.offers.domain.model.OfferFilter
import com.robertruzsa.vbpvkmm.features.offers.domain.repository.RideOfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime

@HiltViewModel
class OffersViewModel @Inject constructor(
    private val offersRepository: RideOfferRepository
) : ViewModel() {
    private val _posts = MutableStateFlow<List<Offer>>(emptyList())
    val offers = _posts.asStateFlow()

    private val _date = MutableStateFlow(DateTimeUtil.now())
    val date = _date.asStateFlow()

    private var filter: OfferFilter? = null

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

    fun onFilterChanged(filter: OfferFilter) {
        this.filter = filter
    }

    fun getSelectableDates(): List<LocalDateTime> {
        val selectableDates = mutableListOf<LocalDateTime>()
        var date = filter?.dateOfTravel ?: DateTimeUtil.now()
        selectableDates.add(date)
        repeat(NUMBER_OF_SELECTABLE_DATES) {
            date = date.plusDays(1)
            selectableDates.add(date)
        }
        return selectableDates
    }

    companion object {
        const val NUMBER_OF_SELECTABLE_DATES = 14
    }
}
