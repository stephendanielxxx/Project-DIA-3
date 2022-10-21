package com.ideaco.projectdia.di

import com.ideaco.projectdia.data.remote.AuthenticationRemoteDataSource
import com.ideaco.projectdia.data.repository.AuthenticationRepository
import com.ideaco.projectdia.data.service.AuthenticationService
import com.ideaco.projectdia.retrofit.AuthenticationRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthenticationModule {
    @Provides
    @Singleton
    fun provideAuthenticationService(): AuthenticationService
        = AuthenticationRetrofit.authenticationService

    @Provides
    @Singleton
    fun provideAuthenticationRemoteDataSource(authenticationService: AuthenticationService): AuthenticationRemoteDataSource
        = AuthenticationRemoteDataSource(authenticationService)

    @Provides
    @Singleton
    fun provideAuthenticationRepository(authenticationRemoteDataSource: AuthenticationRemoteDataSource): AuthenticationRepository
        = AuthenticationRepository(authenticationRemoteDataSource)
}