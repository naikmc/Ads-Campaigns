package com.example.digitalturbine2.api

import com.example.digitalturbine2.model.DefaultResponse
import retrofit2.Call
import retrofit2.http.GET


interface Api {

    @GET("getAds?id=236&password=OVUJ1DJN&siteId=10777&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=100&lname=job")
      fun getDetails():Call<DefaultResponse>

}