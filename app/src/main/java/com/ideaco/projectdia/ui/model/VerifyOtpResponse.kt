package com.ideaco.projectdia.ui.model

import com.google.gson.annotations.SerializedName

/*
{
    "code": 200,
    "status": "SUCCESS",
    "data": {
        "userPhone": "087899190003",
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwODc4OTkxOTAwMDMiLCJleHAiOjE2NjY1MTA2OTJ9.euATjhZGHQ0cRZY-tU5h23PHDzPTTPkhtFdL8ThayYdzTS40idPBBeKu-LvH6ZQn6yX39LwVXwEBrJt_M7Zsug",
        "refreshToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwODc4OTkxOTAwMDMiLCJleHAiOjE2Njc1NDc0OTJ9.6WPPZSEnGH57JEIjzFv2Hx8tmW39gVc6rFZYuBBJ295cQNkCOM-jFvrYjkbItqRh3eL8tQRHbge0tK9w4KSe4A"
    }
}
 */
data class VerifyOtpResponse(
    var code: Int,
    var status: String,
    @SerializedName("data")
    var tokenModel: TokenModel
)
