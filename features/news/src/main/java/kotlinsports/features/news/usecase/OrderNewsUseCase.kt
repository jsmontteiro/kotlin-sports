package kotlinsports.features.news.usecase

import kotlilnsports.libraries.common.UseCase
import kotlinsports.features.news.data.SportsRepository
import kotlinsports.features.news.model.FormatedNews
import kotlinsports.features.news.model.News

internal class OrderNewsUseCase() : UseCase<List<FormatedNews>, List<FormatedNews>> {
    override suspend fun execute(param: List<FormatedNews>): List<FormatedNews> {
        return param
    }
}