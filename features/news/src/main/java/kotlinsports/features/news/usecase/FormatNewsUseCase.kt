package kotlinsports.features.news.usecase

import kotlilnsports.libraries.common.UseCase
import kotlinsports.features.news.data.SportsRepository
import kotlinsports.features.news.model.FormatedNews
import kotlinsports.features.news.model.News
import kotlinsports.features.news.model.SportType

internal class FormatNewsUseCase() : UseCase<News, List<FormatedNews>> {
    override suspend fun execute(param: News): List<FormatedNews> {

        val formatedList: MutableList<FormatedNews> = mutableListOf()

        param.formulaOneNews.forEach {
            formatedList.add(FormatedNews(it.tournament, it.winner, SportType.FORMULA_ONE, it.publicationDate, it.seconds))
        }

        param.nbaNews.forEach {
            formatedList.add(FormatedNews(it.tournament, it.winner, SportType.NBA, it.publicationDate, it.gameNumber.toDouble()))
        }

        param.tennisNews.forEach {
            formatedList.add(FormatedNews(it.tournament, it.winner, SportType.TENNIS, it.publicationDate, it.numberOfSets.toDouble()))
        }

        return formatedList
    }
}