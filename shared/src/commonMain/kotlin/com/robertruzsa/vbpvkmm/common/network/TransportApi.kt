package com.robertruzsa.vbpvkmm.common.network

import com.robertruzsa.vbpvkmm.features.offers.data.dto.RideOfferCreateRequest
import com.robertruzsa.vbpvkmm.features.offers.data.dto.RideOfferQueryResponse
import com.robertruzsa.vbpvkmm.features.searchlocation.data.dto.LocationQueryResultResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
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

    suspend fun search(query: String): LocationQueryResultResponse {
        return httpClient.get {
            url("$BASE_URL/locations")
            parameter("query", query)
        }.body()
    }

    suspend fun createRideOffer(offer: RideOfferCreateRequest): HttpResponse {
        return httpClient.post("$BASE_URL/offers/create") {
            contentType(ContentType.Application.Json)
            setBody(offer)
        }
    }
}
