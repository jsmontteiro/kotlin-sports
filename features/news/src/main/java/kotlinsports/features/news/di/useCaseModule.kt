package kotlinsports.features.news.di

import kotlinsports.features.news.usecase.FormatNewsUseCase
import kotlinsports.features.news.usecase.ListNewsUseCase
import kotlinsports.features.news.usecase.OrderNewsUseCase
import org.koin.dsl.module

internal val useCaseModule = module {
    factory { ListNewsUseCase(repo = get()) }
    factory { FormatNewsUseCase() }
    factory { OrderNewsUseCase() }
}