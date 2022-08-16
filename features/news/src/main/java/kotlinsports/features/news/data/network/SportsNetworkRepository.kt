package kotlinsports.features.news.data.network

import kotlilnsports.libraries.common.mapTo
import kotlinsports.features.news.data.SportsRepository
import kotlinsports.features.news.model.News
import kotlinsports.network.RequestManager

internal class SportsNetworkRepository(private val api: NewsApi) : SportsRepository {
    override suspend fun listSports(): News {
        val apiResponse = RequestManager.requestFromApi { api.listSports() }
        return News(apiResponse?.formulaOneNews?.mapTo() ?: emptyList(),
            apiResponse?.nbaNews?.mapTo() ?: emptyList(),
            apiResponse?.tennisNews?.mapTo() ?: emptyList())
    }
}
