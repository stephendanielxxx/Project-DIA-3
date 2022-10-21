package com.ideaco.projectdia.data.repository

import com.ideaco.projectdia.data.remote.AuthenticationRemoteDataSource
import com.ideaco.projectdia.ui.model.VerifyOtpResponse
import io.reactivex.Single
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val authenticationRemoteDataSource: AuthenticationRemoteDataSource
) {
    fun verifyOtp(phone: String, otp: String): Single<VerifyOtpResponse>
        = authenticationRemoteDataSource.verifyOtp(phone, otp)
}