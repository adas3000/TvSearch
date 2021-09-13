package pl.adam.tv_search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import pl.adam.tv_search.model.model.Result
import pl.adam.tv_search.model.model.TvChapter
import pl.adam.tv_search.model.repository.TvChaptersListRepository
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class TvChaptersListViewModel @Inject constructor(private val repository: TvChaptersListRepository) :
    ViewModel(), CoroutineScope {

    private val _tvList: MutableLiveData<List<TvChapter>> = MutableLiveData()
    val tvList: LiveData<List<TvChapter>> = _tvList

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.IO

    fun searchTextChanged(query: String) {
        if (query.length >= 3) {
            launch {
                when (val result = repository.obtainTvSeriesChapterList(query)) {
                    is Result.Success -> _tvList.postValue(result.data)
                    is Result.Error -> _error.postValue(result.message)
                }
            }
        }
    }


}