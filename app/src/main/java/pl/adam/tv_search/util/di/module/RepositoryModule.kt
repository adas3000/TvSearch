package pl.adam.tv_search.util.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pl.adam.tv_search.model.repository.MockTvChaptersListRepository
import pl.adam.tv_search.model.repository.TvChaptersListRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideTvChaptersList(): TvChaptersListRepository = MockTvChaptersListRepository()
}