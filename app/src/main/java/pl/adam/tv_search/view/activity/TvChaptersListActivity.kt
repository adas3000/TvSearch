package pl.adam.tv_search.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_tv_chapters_list.*
import pl.adam.tv_search.R
import pl.adam.tv_search.viewmodel.TvChaptersListViewModel

@AndroidEntryPoint
class TvChaptersListActivity : AppCompatActivity() {

    private val viewModel: TvChaptersListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_chapters_list)
        setActions()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.tvList.observe(this) {

        }
    }

    private fun setActions() {
        searchSV.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchTextChanged(query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchTextChanged(newText.toString())
                return true
            }
        })
    }
}