package kotlinsports.features.news.ui

import android.content.Context
import android.graphics.drawable.Drawable
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
import kotlinsports.features.news.model.SportType

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
            binding.newsTvPublishedDate.text = new.publicationDate
            binding.newsTvStatistics.text = new.statistics.toString()

            val logo = getLogoSport(this.context, new.sportType)

            binding.newsLogo.setImageDrawable(logo)

        }
    }

    private fun getLogoSport(context: Context, sportType: SportType): Drawable? {
        return when (sportType) {
            SportType.FORMULA_ONE -> {
                ContextCompat.getDrawable(context, R.drawable.ic_f1)
            }
            SportType.NBA -> {
                ContextCompat.getDrawable(context, R.drawable.ic_nba)
            }
            SportType.TENNIS -> {
                ContextCompat.getDrawable(context, R.drawable.ic_tennis)
            }
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