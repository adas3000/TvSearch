package pl.adam.tv_search.model.repository

import pl.adam.tv_search.model.model.TvChapter
import pl.adam.tv_search.model.network.ApiService
import javax.inject.Inject

class RemoteTvChaptersListRepository @Inject constructor(private val apiService: ApiService) :
    TvChaptersListRepository {
    override suspend fun obtainTvSeriesChapterList(query: String): List<TvChapter> =
        apiService.getTvList(query).map {
            TvChapter(
                title = it.show?.name ?: "",
                genres = it.show?.genres ?: emptyList(),
                img = it.show?.image?.medium
            )
        }
}