package com.example.musicplayer2


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class rock(
    @Json(name = "resultCount")
    val resultCount: Int? = null,
    @Json(name = "results")
    val results: List<Result?>? = null
)