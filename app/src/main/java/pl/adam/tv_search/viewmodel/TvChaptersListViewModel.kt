package pl.adam.tv_search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import pl.adam.tv_search.model.model.TvSeriesChapter
import pl.adam.tv_search.model.repository.TvSeriesRepository
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class TvChapterListViewModel @Inject constructor(private val repository: TvSeriesRepository) :
    ViewModel(), CoroutineScope {

    private val _tvSeriesList: MutableLiveData<List<TvSeriesChapter>> = MutableLiveData()
    val tvSeriesList: LiveData<List<TvSeriesChapter>> = _tvSeriesList

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.IO

    fun searchTextChanged(query: String) {
        if (query.length > 3) {
            launch {
                val list = repository.obtainTvSeriesChapterList(query)
                withContext(Dispatchers.Main) {
                    _tvSeriesList.postValue(list)
                }
            }
        }
    }

}