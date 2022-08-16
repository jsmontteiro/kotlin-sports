package kotlinsports.features.news.di

import kotlinsports.features.news.usecase.ListNewsUseCase
import org.koin.dsl.module

internal val useCaseModule = module {
    factory { ListNewsUseCase(repo = get()) }
}