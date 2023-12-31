package com.ahincho.retrofit

import com.google.gson.annotations.SerializedName

data class DogResponse (
    @SerializedName("status") val status: String,
    @SerializedName("message") val images: List<String>
)