package pl.adam.tv_search.model.repository

import pl.adam.tv_search.model.model.TvChapter

class MockTvChaptersListRepository : TvChaptersListRepository {
    override suspend fun obtainTvSeriesChapterList(query: String) = listOf(
        TvChapter(
            title = "a",
            img = "b",
            genre = ""
        ), TvChapter(
            title = "a",
            img = "b",
            genre = ""
        ), TvChapter(
            title = "a",
            img = "b",
            genre = ""
        )
    )
}