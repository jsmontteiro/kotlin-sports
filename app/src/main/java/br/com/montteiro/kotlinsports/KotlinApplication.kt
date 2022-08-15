package br.com.montteiro.kotlinsports

import android.app.Application
import br.com.montteiro.kotlinsports.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KotlinSportsApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@KotlinSportsApplication)
            modules(AppModule.getModules())
        }
    }

}