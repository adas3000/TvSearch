package pl.adam.tv_search.model.repository

import pl.adam.tv_search.model.model.Result
import pl.adam.tv_search.model.model.TvChapter

interface TvChaptersListRepository : Repository {
    suspend fun obtainTvSeriesChapterList(query: String): Result<List<TvChapter>>
}