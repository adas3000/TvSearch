package pl.adam.tv_search.model.repository

import pl.adam.tv_search.model.model.TvSeriesChapter

interface TvSeriesRepository : Repository {
    fun obtainTvSeriesChapterList(): List<TvSeriesChapter>
}