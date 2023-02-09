package com.example.musicplayer2

import android.util.Log
import com.example.musicplayer2.res.ItunesAPI
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.math.E
import

interface Repository {
    fun getListByGenre(term: String): Flow<UIState<SongResponse>>
    // function to getListByGenre(options; Map<String, String>): Flow<UIState<SongResponse>>

}
private const val TAG = "Repository"

class RepositoryImpl @Inject constructor{
    private val itunesAPI: ItunesAPI
    ) : Repository {
        override fun getListByGenre(term: String): Flow<UIState<SongResponse>> = flow {
            emit(UIState.LOADING)
            try {
                val response =  itunesAPI.getListByGenre(term, "music", "song",50")
                        if(response.isSuccessful) {
                            response.body()?.let {
                                Log.d(TAG, "getListByGenre: $it")
                                emit(UIState.SUCCESS(it))
                            } ?: throw NullSongsResponse()
                        } else
                            throw FailureResponse(respone.errorBody()?.string())
                            }catch (e: Exception) {
                                Log.e(TAG, "getListByGenre: $it")
                                emit(UIState.ERROR(e))
                        }
            }
        }
    }

}