package com.example.musicplayer2


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class pop(
    @Json(name = "resultCount")
    val resultCount: Int? = 0,
    @Json(name = "results")
    val results: List<ResultX>? = listOf()
)