package pl.adam.tv_search.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import pl.adam.tv_search.R
import pl.adam.tv_search.viewmodel.TvSeriesListViewModel

@AndroidEntryPoint
class TvSeriesListActivity : AppCompatActivity() {

    private val viewModel: TvSeriesListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_series_list)
    }
}