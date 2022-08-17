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
            formatedList.add(FormatedNews(
                tournament = it.tournament,
                winner = it.winner,
                sportType = SportType.NBA,
                publicationDate = it.publicationDate,
                gameNumber = it.gameNumber,
                mvp = it.mvp,
                looser = it.looser))
        }

        param.tennisNews.forEach {
            formatedList.add(FormatedNews(
                tournament = it.tournament,
                winner = it.winner,
                sportType = SportType.TENNIS,
                publicationDate = it.publicationDate,
                looser = it.looser,
                numberOfSets = it.numberOfSets
            ))
        }

        return formatedList
    }
}