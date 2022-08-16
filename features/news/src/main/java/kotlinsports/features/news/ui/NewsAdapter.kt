package kotlinsports.features.news.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinsports.features.news.R
import kotlinsports.features.news.databinding.NewsItemCardBinding
import kotlinsports.features.news.model.FormatedNews

class NewsAdapter : ListAdapter<FormatedNews, NewsAdapter.ViewHolder>(DIFF_UTIL) {

    private lateinit var binding: NewsItemCardBinding

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = NewsItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = getItem(position)

        with(holder.itemView) {
            binding.newsTvTournament.text = new.tournament
            binding.newsTvWinner.text = new.winner
            binding.newsLogo.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_nba))
        }
    }
}

private object DIFF_UTIL : DiffUtil.ItemCallback<FormatedNews>() {
    override fun areItemsTheSame(
        oldItem: FormatedNews,
        newItem: FormatedNews
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: FormatedNews,
        newItem: FormatedNews
    ): Boolean {
        return oldItem.tournament == newItem.tournament
    }

}