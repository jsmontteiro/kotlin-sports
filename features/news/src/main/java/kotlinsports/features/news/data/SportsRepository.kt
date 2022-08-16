package kotlinsports.features.news.data

import kotlinsports.features.news.model.News

internal interface SportsRepository {
    suspend fun listSports(): News
}