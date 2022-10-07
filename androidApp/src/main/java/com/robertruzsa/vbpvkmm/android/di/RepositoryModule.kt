package com.robertruzsa.vbpvkmm.android.di

import com.robertruzsa.vbpvkmm.features.offers.data.repository.RideOfferRepositoryImpl
import com.robertruzsa.vbpvkmm.features.offers.domain.repository.RideOfferRepository
import com.robertruzsa.vbpvkmm.features.searchlocation.data.repository.SearchLocationRepositoryImpl
import com.robertruzsa.vbpvkmm.features.searchlocation.domain.repository.SearchLocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRideOfferRepository(): RideOfferRepository = RideOfferRepositoryImpl()

    @Provides
    @Singleton
    fun provideSearchLocationRepository(): SearchLocationRepository = SearchLocationRepositoryImpl()
}
