package com.ideaco.projectdia.di

import com.ideaco.projectdia.data.remote.AnimalRemoteDataSource
import com.ideaco.projectdia.data.repository.AnimalRepository
import com.ideaco.projectdia.data.service.AnimalService
import com.ideaco.projectdia.retrofit.AnimalRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AnimalModule {

    @Provides
    @Singleton
    fun provideAnimalService(): AnimalService = AnimalRetrofit.animalService

    @Provides
    @Singleton
    fun provideAnimalRemoteDataSource(animalService: AnimalService): AnimalRemoteDataSource
        = AnimalRemoteDataSource(animalService)

    @Provides
    @Singleton
    fun provideAnimalRepository(animalRemoteDataSource: AnimalRemoteDataSource): AnimalRepository
        = AnimalRepository(animalRemoteDataSource)
}