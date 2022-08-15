package kotlinsports.features.news.di

import org.koin.core.module.Module

object NewsModule {
    fun getModules(): Array<Module> = arrayOf(
        dataModule,
        useCaseModule,
        uiModule
    )
}
