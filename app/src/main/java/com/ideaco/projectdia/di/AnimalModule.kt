package com.ideaco.projectdia.di

import android.content.Context
import androidx.room.Room
import com.ideaco.projectdia.data.local.AnimalLocalDataSource
import com.ideaco.projectdia.data.remote.AnimalRemoteDataSource
import com.ideaco.projectdia.data.repository.AnimalRepository
import com.ideaco.projectdia.data.service.AnimalService
import com.ideaco.projectdia.retrofit.AnimalRetrofit
import com.ideaco.projectdia.room.AnimalDao
import com.ideaco.projectdia.room.AnimalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideAnimalRepository(
        animalRemoteDataSource: AnimalRemoteDataSource,
        animalLocalDataSource: AnimalLocalDataSource
    ): AnimalRepository
        = AnimalRepository(animalRemoteDataSource, animalLocalDataSource)

    @Provides
    @Singleton
    fun provideAnimalDatabase(@ApplicationContext appContext: Context): AnimalDatabase
        = Room.databaseBuilder(appContext, AnimalDatabase::class.java, "animalDatabase").build()

    @Provides
    @Singleton
    fun provideAnimalDao(animalDatabase: AnimalDatabase): AnimalDao
        = animalDatabase.animalDao()

    @Provides
    @Singleton
    fun provideAnimalLocalDataSource(animalDao: AnimalDao): AnimalLocalDataSource
        = AnimalLocalDataSource(animalDao)

}