package com.example.retrofit2jsonkotlin

import com.google.gson.annotations.SerializedName

class MoviesModel (
    @SerializedName("txnType") val txnType: String?,
    @SerializedName("bankRef") val bankRef: String?,
    @SerializedName("refNo1") val refNo1: String?,
    @SerializedName("refNo2") val refNo2: String?,
    @SerializedName("amount") val amount: Int?,
    @SerializedName("partnerRef") val partnerRef: String?,
    @SerializedName("reasonCode") val reasonCode: String?,
    @SerializedName("reasonDescription") val reasonDescription: String?

)