package com.sportz.interactive.di

import com.sportz.interactive.data.repository.match.MatchRepository
import com.sportz.interactive.data.repository.match.MatchRepositoryImpl
import com.sportz.interactive.data.repository.squad.SquadRepository
import com.sportz.interactive.data.repository.squad.SquadRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMatchRepository(
        matchRepositoryImpl: MatchRepositoryImpl
    ): MatchRepository

    @Binds
    @Singleton
    abstract fun bindSquadRepository(
        matchRepositoryImpl: SquadRepositoryImpl
    ): SquadRepository
}