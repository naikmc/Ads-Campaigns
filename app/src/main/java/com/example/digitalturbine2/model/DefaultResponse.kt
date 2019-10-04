package com.example.digitalturbine2.model


import com.google.gson.annotations.SerializedName

data class DefaultResponse(
    @SerializedName("campaigns")
    var campaigns: List<Campaign?>?,
    @SerializedName("errorMessage")
    var errorMessage: Any?,
    @SerializedName("responseTime")
    var responseTime: String?,
    @SerializedName("serverId")
    var serverId: Any?,
    @SerializedName("totalCampaignsRequested")
    var totalCampaignsRequested: Int?,
    @SerializedName("version")
    var version: String?
)