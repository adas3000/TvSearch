package pl.adam.tv_search.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.adam.tv_search.R
import pl.adam.tv_search.model.model.TvChapter

class TvChapterAdapter(val tvChaptersList: List<TvChapter>) :
    RecyclerView.Adapter<TvChapterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = tvChaptersList[position].title
    }

    override fun getItemCount() = tvChaptersList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val logo = view.findViewById<ImageView>(R.id.logoIV)
        val title = view.findViewById<TextView>(R.id.titleTV)
        val firstGenre = view.findViewById<TextView>(R.id.firstGenreTV)
        val secondGenre = view.findViewById<TextView>(R.id.secondGenreTV)
        val thirdGenre = view.findViewById<TextView>(R.id.thirdGenreTV)
    }

}