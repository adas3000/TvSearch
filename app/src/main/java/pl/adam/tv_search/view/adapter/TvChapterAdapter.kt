package pl.adam.tv_search.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.adam.tv_search.R
import pl.adam.tv_search.model.model.TvChapter
import pl.adam.tv_search.util.extensions.load

class TvChapterAdapter(var tvChaptersList: List<TvChapter>) :
    RecyclerView.Adapter<TvChapterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_tv_chapter, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvChapter = tvChaptersList[position]
        holder.title.text = tvChapter.title
        holder.logo.load(tvChapter.img)
        if (tvChapter.genres.isNotEmpty()) {
            holder.firstGenre.text = tvChapter.genres[0]
        }
        if (tvChapter.genres.size >= 2) {
            holder.secondGenre.text = tvChapter.genres[1]
        }
        if (tvChapter.genres.size >= 3) {
            holder.thirdGenre.text = tvChapter.genres[2]
        }
    }

    override fun getItemCount() = tvChaptersList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val logo: ImageView = view.findViewById(R.id.logoIV)
        val title: TextView = view.findViewById(R.id.titleTV)
        val firstGenre: TextView = view.findViewById(R.id.firstGenreTV)
        val secondGenre: TextView = view.findViewById(R.id.secondGenreTV)
        val thirdGenre: TextView = view.findViewById(R.id.thirdGenreTV)
    }

}