package com.robertruzsa.vbpvkmm.features.searchlocation.data.repository

import com.robertruzsa.vbpvkmm.common.network.TransportApi
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.searchlocation.data.mapper.toDomainModel
import com.robertruzsa.vbpvkmm.features.searchlocation.domain.repository.SearchLocationRepository

class SearchLocationRepositoryImpl : SearchLocationRepository {

    private val api = TransportApi()

    override suspend fun search(query: String): List<Location> {
        return api.search(query).toDomainModel()
    }
}
