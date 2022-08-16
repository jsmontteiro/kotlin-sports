package kotlinsports.features.news.data.network.schemas

import com.google.gson.annotations.SerializedName
import kotlilnsports.libraries.common.MapTo
import kotlinsports.features.news.model.Tennis
import java.util.*

class TennisSchema(
    @SerializedName("looser")
    val looser: String,
    @SerializedName("numberOfSets")
    val numberOfSets: Int,
    @SerializedName("publicationDate")
    val publicationDate: String,
    @SerializedName("tournament")
    val tournament: String,
    @SerializedName("winner")
    val winner: String
) : MapTo<Tennis> {
    override fun mapTo() = Tennis(
        looser = looser,
        numberOfSets = numberOfSets,
        publicationDate = publicationDate,
        tournament = tournament,
        winner = winner
    )
}