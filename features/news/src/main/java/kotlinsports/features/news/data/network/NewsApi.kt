package kotlinsports.features.news.data.network

import kotlinsports.features.news.data.network.schemas.NewsSchema
import retrofit2.Response
import retrofit2.http.POST

internal interface NewsApi {
    @POST("results")
    suspend fun listSports(): Response<NewsSchema>
}