package kotlinsports.features.news.data.network.schemas

import com.google.gson.annotations.SerializedName
import kotlilnsports.libraries.common.MapTo
import kotlinsports.features.news.model.FormulaOne
import java.util.*

class FormulaOneSchema(
    @SerializedName("publicationDate")
    val publicationDate: String,
    @SerializedName("seconds")
    val seconds: Double,
    @SerializedName("tournament")
    val tournament: String,
    @SerializedName("winner")
    val winner: String
) : MapTo<FormulaOne> {
    override fun mapTo() = FormulaOne(
        publicationDate = publicationDate,
        seconds = seconds,
        tournament = tournament,
        winner = winner
    )
}