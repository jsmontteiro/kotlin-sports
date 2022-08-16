package kotlinsports.features.news.data.network.schemas

import com.google.gson.annotations.SerializedName
import kotlilnsports.libraries.common.MapTo
import kotlinsports.features.news.model.FormulaOne
import kotlinsports.features.news.model.Nba
import kotlinsports.features.news.model.News
import kotlinsports.features.news.model.Tennis

class NewsSchema(
    @SerializedName("f1Results")
    val formulaOneNews: List<FormulaOneSchema>,

    @SerializedName("nbaResults")
    val nbaNews: List<NbaSchema>,

    @SerializedName("Tennis")
    val tennisNews: List<TennisSchema>
) : MapTo<News> {
    override fun mapTo() = News(
        formulaOneNews = formulaOneNews.map { it.mapTo() },
        nbaNews = nbaNews.map { it.mapTo() },
        tennisNews = tennisNews.map { it.mapTo() }
    )
}