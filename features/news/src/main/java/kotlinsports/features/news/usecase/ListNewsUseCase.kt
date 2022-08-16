package kotlinsports.features.news.usecase

import kotlilnsports.libraries.common.UseCase
import kotlinsports.features.news.data.SportsRepository
import kotlinsports.features.news.model.News

internal class ListNewsUseCase(private val repo: SportsRepository) :
    UseCase<Unit?, News> {
    override suspend fun execute(param: Unit?): News {
        return repo.listSports()
    }
}