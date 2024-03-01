package com.aspen_compose.di

import android.content.Context
import com.aspen_compose.network.CountriesAndCitiesAPI
import com.aspen_compose.network.NetworkClient
import com.aspen_compose.network.RetrofitNetworkClient
import com.aspen_compose.network.repository.CitiesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideRickAndMortyService(): CountriesAndCitiesAPI =
        Retrofit.Builder()
            .baseUrl("https://countriesnow.space/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesAndCitiesAPI::class.java)

    @Provides
    @Singleton
    fun provideNetworkClient(
        @ApplicationContext context: Context,
        countriesAndCitiesService: CountriesAndCitiesAPI
    ): NetworkClient =
        RetrofitNetworkClient(context, countriesAndCitiesService)

    @Provides
    @Singleton
    fun provideCitiesRepositoryImpl(
        networkClient: NetworkClient,
        @ApplicationContext context: Context
    ): CitiesRepositoryImpl =
        CitiesRepositoryImpl(networkClient, context)

}