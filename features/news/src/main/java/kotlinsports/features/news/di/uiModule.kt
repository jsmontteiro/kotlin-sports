package kotlinsports.features.news.di

import kotlinsports.features.news.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val uiModule = module {
    viewModel { MainViewModel(listNewsUseCase = get()) }
}