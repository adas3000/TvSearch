package pl.adam.tv_search.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_tv_chapters_list.*
import pl.adam.tv_search.R
import pl.adam.tv_search.view.adapter.TvChapterAdapter
import pl.adam.tv_search.viewmodel.TvChaptersListViewModel

@AndroidEntryPoint
class TvChaptersListActivity : AppCompatActivity() {

    private val viewModel: TvChaptersListViewModel by viewModels()

    private val adapter = TvChapterAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_chapters_list)
        setupAdapter()
        setActions()
        observeViewModel()
    }

    private fun setupAdapter() {
        listRV.adapter = adapter
        listRV.setHasFixedSize(true)
    }

    private fun observeViewModel() {
        viewModel.tvList.observe(this) {
            adapter.tvChaptersList = it
            adapter.notifyDataSetChanged()
        }
        viewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setActions() {
        searchSV.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchTextChanged(query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchTextChanged(newText.toString())
                return false
            }
        })
    }
}