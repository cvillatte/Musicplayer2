package com.example.musicplayer2.res

interface ItunesAPI {

@GET(SEARCH)
suspend fun getListByGenre(
    @Query("term") term: String,
    @Query("amp;media", encoded = true) media: String,
    @Query("amp;entity", encoded = true) entity: String,
    @Query("amp;limit", encoded = true) limit: String,
) : Response<SongResponse>

    companion object
        const val BASE_URL = "https://itunes.apple.com/"
        private const val SEARCH = "search"
)
}