package com.robertruzsa.vbpvkmm.android.features.offers.di

import com.robertruzsa.vbpvkmm.features.offers.data.repository.RideOfferRepositoryImpl
import com.robertruzsa.vbpvkmm.features.offers.domain.repository.RideOfferRepository
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
}
