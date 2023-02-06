package com.walletconnect.codingchallenge.data.model.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClothingItemDTO(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "price")
    val price: Double,
    @Json(name = "description")
    val description: String,
    @Json(name = "category")
    val category: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "rating")
    val rating: RatingDTO
)