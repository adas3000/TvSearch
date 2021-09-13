package pl.adam.tv_search.model.network

import pl.adam.tv_search.model.model.RemoteTvChapter
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/shows")
    suspend fun getTvList(@Query("q") query: String): List<RemoteTvChapter>
}