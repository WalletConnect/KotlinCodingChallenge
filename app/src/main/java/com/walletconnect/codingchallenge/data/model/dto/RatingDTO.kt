package com.walletconnect.codingchallenge.data.model.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RatingDTO(
    @Json(name = "rate")
    val rate: Double,
    @Json(name = "count")
    val count: Int
)