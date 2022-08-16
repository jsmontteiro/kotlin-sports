package kotlinsports.features.news.di

import kotlinsports.features.news.data.SportsRepository
import kotlinsports.features.news.data.network.NewsApi
import kotlinsports.features.news.data.network.SportsNetworkRepository
import kotlinsports.network.ApiClientBuilder
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    single { ApiClientBuilder.createServiceApi(NewsApi::class.java) }
    factory { SportsNetworkRepository(api = get()) } bind SportsRepository::class
}