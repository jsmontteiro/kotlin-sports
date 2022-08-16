package kotlinsports.features.news.data.network.schemas

import com.google.gson.annotations.SerializedName
import kotlilnsports.libraries.common.MapTo
import kotlinsports.features.news.model.Nba
import java.util.*

class NbaSchema(
    @SerializedName("gameNumber")
    val gameNumber: Int,
    @SerializedName("looser")
    val looser: String,
    @SerializedName("mvp")
    val mvp: String,
    @SerializedName("publicationDate")
    val publicationDate: String,
    @SerializedName("tournament")
    val tournament: String,
    @SerializedName("winner")
    val winner: String
) : MapTo<Nba> {
    override fun mapTo() = Nba(
        gameNumber = gameNumber,
        looser = looser,
        mvp = mvp,
        publicationDate = publicationDate,
        tournament = tournament,
        winner = winner
    )
}