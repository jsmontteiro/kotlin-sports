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
import kotlinsports.features.news.databinding.NewsItemCardFormulaOneBinding
import kotlinsports.features.news.databinding.NewsItemCardNbaBinding
import kotlinsports.features.news.databinding.NewsItemCardTennisBinding
import kotlinsports.features.news.model.*

class NewsAdapter() : ListAdapter<FormatedNews, NewsAdapter.ViewHolder>(DIFF_UTIL) {

    private lateinit var bidingFormulaOne: NewsItemCardFormulaOneBinding
    private lateinit var bidingNba: NewsItemCardNbaBinding
    private lateinit var bidingTennis: NewsItemCardTennisBinding

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            LAYOUT_FORMULA_ONE -> {
                bidingFormulaOne = NewsItemCardFormulaOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolder(bidingFormulaOne.root)
            }
            LAYOUT_NBA -> {
                bidingNba = NewsItemCardNbaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolder(bidingNba.root)
            }
            else -> {
                bidingTennis = NewsItemCardTennisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolder(bidingTennis.root)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val new = getItem(position)
        return when (new.sportType) {
            SportType.FORMULA_ONE -> {
                LAYOUT_FORMULA_ONE
            }
            SportType.NBA -> {
                LAYOUT_NBA
            }
            else -> {
                LAYOUT_TENNIS
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = getItem(position)

        if (new.sportType == SportType.FORMULA_ONE) {
            with(holder.itemView) {
                bidingFormulaOne.newsTvTournament.text = new.tournament
                bidingFormulaOne.newsTvWinner.text = new.winner
                bidingFormulaOne.newsTvPublishedDate.text = new.publicationDate
                bidingFormulaOne.newsTvSeconds.text = new.seconds.toString()

                val logo = getLogoSport(this.context, new.sportType)
                bidingFormulaOne.newsLogo.setImageDrawable(logo)
            }
        }

        if (new.sportType == SportType.NBA) {
            with(holder.itemView) {
                bidingNba.newsTvTournament.text = new.tournament
                bidingNba.newsTvWinner.text = new.winner
                bidingNba.newsTvPublishedDate.text = new.publicationDate
                bidingNba.newsTvGameNumber.text = new.gameNumber.toString()
                bidingNba.newsTvLooser.text = new.looser
                bidingNba.newsTvMvp.text = new.mvp

                val logo = getLogoSport(this.context, new.sportType)
                bidingNba.newsLogo.setImageDrawable(logo)
            }
        }

        if (new.sportType == SportType.TENNIS) {
            with(holder.itemView) {
                bidingTennis.newsTvTournament.text = new.tournament
                bidingTennis.newsTvWinner.text = new.winner
                bidingTennis.newsTvPublishedDate.text = new.publicationDate
                bidingTennis.newsTvLooser.text = new.looser
                bidingTennis.newsTvNumberOfSets.text = new.numberOfSets.toString()

                val logo = getLogoSport(this.context, new.sportType)
                bidingTennis.newsLogo.setImageDrawable(logo)
            }
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

    companion object{
        const val LAYOUT_FORMULA_ONE = 1
        const val LAYOUT_NBA = 2
        const val LAYOUT_TENNIS = 3
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
        return oldItem.publicationDate == newItem.publicationDate
    }

}