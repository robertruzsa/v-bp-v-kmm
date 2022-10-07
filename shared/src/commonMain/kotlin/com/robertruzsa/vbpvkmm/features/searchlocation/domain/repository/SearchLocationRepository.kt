package com.robertruzsa.vbpvkmm.features.searchlocation.domain.repository

import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location

interface SearchLocationRepository {
    suspend fun search(query: String): List<Location>
}
