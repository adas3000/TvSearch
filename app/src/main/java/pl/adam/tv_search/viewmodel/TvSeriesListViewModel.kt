package pl.adam.tv_search.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.adam.tv_search.model.repository.TvSeriesRepository
import javax.inject.Inject

@HiltViewModel
class TvSeriesListViewModel @Inject constructor(private val repository: TvSeriesRepository) :
    ViewModel() {



}