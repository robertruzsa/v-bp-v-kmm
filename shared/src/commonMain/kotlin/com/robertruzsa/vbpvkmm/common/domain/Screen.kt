package com.robertruzsa.vbpvkmm.common.domain

sealed class Screen(val route: String, val title: String) {
    object Login : Screen("login", "Bejelentkezés")
    object Posts : Screen("posts", "Posztok")
    object Offers : Screen("offers", "Kínál")
    object Requests : Screen("requests", "Keres")
    object SearchOffers : Screen("search_offers", "Keresés")
    object SearchLocation : Screen("search_location", "Keresés")
    object Calendar : Screen("calendar", "Dátum")
    object CreateOffer : Screen("create_offer", "Hirdetés")
}
