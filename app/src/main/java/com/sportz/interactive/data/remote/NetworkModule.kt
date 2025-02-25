package com.sportz.interactive.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://demo.sportz.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMatchApiService(retrofit: Retrofit): MatchApiService {
        return retrofit.create(MatchApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSquadApiService(retrofit: Retrofit): SquadApiService {
        return retrofit.create(SquadApiService::class.java)
    }
}