package pl.adam.tv_search.model.repository

import pl.adam.tv_search.model.model.TvSeriesChapter

interface TvSeriesRepository : Repository {
    suspend fun obtainTvSeriesChapterList(query: String): List<TvSeriesChapter>
}