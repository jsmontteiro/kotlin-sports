package kotlinsports.features.news.model

class FormatedNews(
    val tournament: String,
    val winner: String,
    val sportType: SportType,
    val publicationDate: String,
    val seconds: Double? = null,
    val gameNumber: Int? = null,
    val looser: String? = null,
    val mvp: String? = null,
    val numberOfSets: Int? = null
)