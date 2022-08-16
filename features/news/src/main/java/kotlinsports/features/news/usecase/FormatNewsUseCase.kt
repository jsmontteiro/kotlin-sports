package kotlinsports.features.news.usecase

import kotlilnsports.libraries.common.UseCase
import kotlinsports.features.news.data.SportsRepository
import kotlinsports.features.news.model.FormatedNews
import kotlinsports.features.news.model.News

internal class FormatNewsUseCase() : UseCase<News, List<FormatedNews>> {
    override suspend fun execute(param: News): List<FormatedNews> {

        var formatedList: MutableList<FormatedNews> = mutableListOf()

        param.formulaOneNews.forEach {
            formatedList.add(FormatedNews(it.tournament, it.winner))
        }

        param.nbaNews.forEach {
            formatedList.add(FormatedNews(it.tournament, it.winner))
        }

        param.tennisNews.forEach {
            formatedList.add(FormatedNews(it.tournament, it.winner))
        }

        return formatedList
    }
}