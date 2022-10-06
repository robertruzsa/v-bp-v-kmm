package com.robertruzsa.vbpvkmm.common.network

import com.robertruzsa.vbpvkmm.features.offers.data.dto.RideOfferQueryResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class TransportApi {

    companion object {
        const val BASE_URL = "http://192.168.0.103:8080"
    }

    private val httpClient = HttpClient {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getAllOffers(): RideOfferQueryResponse {
        return httpClient.get("$BASE_URL/offers/list").body()
    }
}
