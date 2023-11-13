package com.sandbox.modularsandbox.data

import com.google.gson.annotations.SerializedName


data class JokeDto(
    @SerializedName("icon_url")
    val iconUrl: String,
    val id: String,
    val url: String,
    val value: String
)