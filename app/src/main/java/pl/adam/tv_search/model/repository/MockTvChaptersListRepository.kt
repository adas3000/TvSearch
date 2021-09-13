package pl.adam.tv_search.model.repository

import pl.adam.tv_search.model.model.Result
import pl.adam.tv_search.model.model.TvChapter
import javax.inject.Inject

class MockTvChaptersListRepository @Inject constructor() : TvChaptersListRepository {
    override suspend fun obtainTvSeriesChapterList(query: String): Result<List<TvChapter>> =
        Result.Success(
            listOf(
                TvChapter(
                    title = "Action",
                    img = "https://static.tvmaze.com/uploads/images/medium_portrait/51/128054.jpg",
                    genres = listOf("Comedy")
                ), TvChapter(
                    title = "Action",
                    img = "https://static.tvmaze.com/uploads/images/medium_portrait/188/470746.jpg",
                    genres = listOf("Sports")
                ), TvChapter(
                    title = "Action Team",
                    img = "https://static.tvmaze.com/uploads/images/medium_portrait/146/367368.jpg",
                    genres = listOf("ITV2")
                )
            )
        )
}