package com.ideaco.projectdia.data.remote

import com.ideaco.projectdia.data.service.AuthenticationService
import com.ideaco.projectdia.ui.model.VerifyOtpResponse
import io.reactivex.Single
import javax.inject.Inject

class AuthenticationRemoteDataSource @Inject constructor(
    private val authenticationService: AuthenticationService) {
    fun verifyOtp(phone: String, otp: String): Single<VerifyOtpResponse>
        = authenticationService.verifyOtp(phone, otp)
}