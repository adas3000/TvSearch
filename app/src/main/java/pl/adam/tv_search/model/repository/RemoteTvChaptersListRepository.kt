package pl.adam.tv_search.model.repository

import pl.adam.tv_search.model.model.Result
import pl.adam.tv_search.model.model.TvChapter
import pl.adam.tv_search.model.network.ApiService
import javax.inject.Inject

class RemoteTvChaptersListRepository @Inject constructor(private val apiService: ApiService) :
    TvChaptersListRepository {
    override suspend fun obtainTvSeriesChapterList(query: String): Result<List<TvChapter>> {
        return try {
            Result.Success(apiService.getTvList(query).map {
                TvChapter(
                    title = it.show?.name ?: "",
                    genres = it.show?.genres ?: emptyList(),
                    img = it.show?.image?.medium
                )
            })
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            Result.Error(throwable.message.toString())
        }
    }
}