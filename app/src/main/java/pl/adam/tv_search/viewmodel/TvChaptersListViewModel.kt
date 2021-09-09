package pl.adam.tv_search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import pl.adam.tv_search.model.model.TvChapter
import pl.adam.tv_search.model.repository.TvChaptersListRepository
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class TvChaptersListViewModel @Inject constructor(private val repository: TvChaptersListRepository) :
    ViewModel(), CoroutineScope {

    private val _tvList: MutableLiveData<List<TvChapter>> = MutableLiveData()
    val tvList: LiveData<List<TvChapter>> = _tvList

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.IO

    fun searchTextChanged(query: String) {
        if (query.length > 3) {
            launch {
                val list = repository.obtainTvSeriesChapterList(query)
                _tvList.postValue(list)
            }
        }
    }

}