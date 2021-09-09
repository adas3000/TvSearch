package pl.adam.tv_search.model.repository

import pl.adam.tv_search.model.model.TvChapter
import javax.inject.Inject

class MockTvChaptersListRepository @Inject constructor() : TvChaptersListRepository {
    override suspend fun obtainTvSeriesChapterList(query: String) = listOf(
        TvChapter(
            title = "Action",
            img = "https://static.tvmaze.com/uploads/images/medium_portrait/51/128054.jpg",
            genre = "Comedy"
        ), TvChapter(
            title = "Action",
            img = "https://static.tvmaze.com/uploads/images/medium_portrait/188/470746.jpg",
            genre = "Sports"
        ), TvChapter(
            title = "Action Team",
            img = "https://static.tvmaze.com/uploads/images/medium_portrait/146/367368.jpg",
            genre = "ITV2"
        )
    )
}