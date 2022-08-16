package kotlinsports.features.news.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinsports.features.news.model.News
import kotlinsports.features.news.usecase.ListNewsUseCase
import kotlinsports.ui_components.BaseViewModel

internal class MainViewModel(val listNewsUseCase:ListNewsUseCase):BaseViewModel() {
    private val _news = MutableLiveData<News>()
    val news: LiveData<News> = _news

    var isInitialized = false
        private set

    fun init() {
        if (!isInitialized) {
            doAsyncWork {
                _news.value = listNewsUseCase.execute(null)
                isInitialized = true
            }
        }
    }
}