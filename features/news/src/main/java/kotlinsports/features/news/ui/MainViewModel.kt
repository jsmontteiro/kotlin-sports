package kotlinsports.features.news.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinsports.features.news.model.FormatedNews
import kotlinsports.features.news.model.News
import kotlinsports.features.news.usecase.FormatNewsUseCase
import kotlinsports.features.news.usecase.ListNewsUseCase
import kotlinsports.features.news.usecase.OrderNewsUseCase
import kotlinsports.ui_components.BaseViewModel

internal class MainViewModel(
    private val listNewsUseCase: ListNewsUseCase,
    private val formatNewsUseCase: FormatNewsUseCase,
    private val orderNewsUseCase: OrderNewsUseCase
) : BaseViewModel() {

    private lateinit var _news: News
    private lateinit var _newsList: List<FormatedNews>

    private val _newsFormated = MutableLiveData<List<FormatedNews>>()
    val newsFormated: LiveData<List<FormatedNews>> = _newsFormated

    var isInitialized = false
        private set

    fun init() {
        if (!isInitialized) {
            doAsyncWork {
                _news = listNewsUseCase.execute(null)
                formatList(_news)
            }
        }
    }

    private fun formatList(news: News) {
        doAsyncWork {
            _newsList = formatNewsUseCase.execute(news)
            orderList()
        }
    }

    private fun orderList() {
        doAsyncWork {
            _newsFormated.value = orderNewsUseCase.execute(_newsList)
            isInitialized = true
        }
    }
}