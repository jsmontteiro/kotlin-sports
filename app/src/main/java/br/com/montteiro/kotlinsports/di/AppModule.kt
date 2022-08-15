package br.com.montteiro.kotlinsports.di

import kotlinsports.features.news.di.NewsModule

object AppModule {
    fun getModules() = listOf(
        *NewsModule.getModules()
    )
}