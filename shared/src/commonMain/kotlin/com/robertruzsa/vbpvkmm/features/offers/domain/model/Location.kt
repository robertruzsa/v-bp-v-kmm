package com.robertruzsa.vbpvkmm.features.offers.domain.model

import com.robertruzsa.vbpvkmm.features.searchlocation.domain.model.SearchResult
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val name: String = ""
) : SearchResult {
    override val displayName: String
        get() = name
}
