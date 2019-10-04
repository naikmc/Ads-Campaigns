package com.example.digitalturbine2.model


import com.google.gson.annotations.SerializedName

data class Campaign(
    @SerializedName("advertiserDomainUrl")
    var advertiserDomainUrl: Any?,
    @SerializedName("apks")
    var apks: Any?,
    @SerializedName("appId")
    var appId: String?,
    @SerializedName("appPrivacyPolicyUrl")
    var appPrivacyPolicyUrl: String?,
    @SerializedName("averageRatingImageURL")
    var averageRatingImageURL: String?,
    @SerializedName("bidRate")
    var bidRate: Double?,
    @SerializedName("billingTypeId")
    var billingTypeId: Int?,
    @SerializedName("callToAction")
    var callToAction: String?,
    @SerializedName("campaignDisplayOrder")
    var campaignDisplayOrder: Int?,
    @SerializedName("campaignId")
    var campaignId: Int?,
    @SerializedName("campaignTypeId")
    var campaignTypeId: Int?,
    @SerializedName("carrier")
    var carrier: Any?,
    @SerializedName("categoryName")
    var categoryName: String?,
    @SerializedName("clickProxyURL")
    var clickProxyURL: String?,
    @SerializedName("creativeId")
    var creativeId: Int?,
    @SerializedName("developerName")
    var developerName: Any?,
    @SerializedName("dtPrivacyPolicyUrl")
    var dtPrivacyPolicyUrl: Any?,
    @SerializedName("externalMetadata")
    var externalMetadata: Any?,
    @SerializedName("googlePlayAppStoreUrl")
    var googlePlayAppStoreUrl: Any?,
    @SerializedName("homeScreen")
    var homeScreen: Boolean?,
    @SerializedName("impressionTrackingURL")
    var impressionTrackingURL: String?,
    @SerializedName("isRandomPick")
    var isRandomPick: Boolean?,
    @SerializedName("longDescription")
    var longDescription: Any?,
    @SerializedName("maxOSVersion")
    var maxOSVersion: Any?,
    @SerializedName("minOSVersion")
    var minOSVersion: String?,
    @SerializedName("numberOfDownloads")
    var numberOfDownloads: String?,
    @SerializedName("numberOfRatings")
    var numberOfRatings: String?,
    @SerializedName("postInstallActions")
    var postInstallActions: List<Any?>?,
    @SerializedName("productDescription")
    var productDescription: String?,
    @SerializedName("productId")
    var productId: Int?,
    @SerializedName("productImage")
    var productImage: Any?,
    @SerializedName("productName")
    var productName: String?,
    @SerializedName("productThumbnail")
    var productThumbnail: String?,
    @SerializedName("rating")
    var rating: Double?,
    @SerializedName("screenshots")
    var screenshots: Any?,
    @SerializedName("stiEnabled")
    var stiEnabled: Boolean?,
    @SerializedName("tstiEligible")
    var tstiEligible: Boolean?
)