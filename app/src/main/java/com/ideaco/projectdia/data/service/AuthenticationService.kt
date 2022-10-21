package com.ideaco.projectdia.data.service

import com.ideaco.projectdia.ui.model.VerifyOtpResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthenticationService {
    @FormUrlEncoded
    @POST("/api/v1/login/verifyOtp")
    fun verifyOtp(@Field("user_phone") userPhone: String,
        @Field("otp") otp: String): Single<VerifyOtpResponse>
}