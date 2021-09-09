package pl.adam.tv_search.model.repository

import pl.adam.tv_search.model.model.TvSeriesChapter

class MockTvSeriesRepository : TvSeriesRepository {
    override suspend fun obtainTvSeriesChapterList(query: String) = listOf(
        TvSeriesChapter(
            title = "a",
            img = "b",
            genre = ""
        ), TvSeriesChapter(
            title = "a",
            img = "b",
            genre = ""
        ), TvSeriesChapter(
            title = "a",
            img = "b",
            genre = ""
        )
    )
}