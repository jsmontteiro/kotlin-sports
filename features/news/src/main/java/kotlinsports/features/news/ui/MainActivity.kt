package kotlinsports.features.news.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinsports.features.news.databinding.NewsActivityMainBinding
import kotlinsports.ui_components.externsions.createLoadingDialog
import kotlinsports.ui_components.externsions.showMessage
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: NewsActivityMainBinding
    private val newsAdapter = NewsAdapter()
    private val viewModel: MainViewModel by viewModel()

    private val loadingDialog by lazy {
        createLoadingDialog()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewsActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupObservers()

        viewModel.init()
    }

    private fun setupView() {
        binding.mainRvNews.adapter = newsAdapter
    }

    private fun setupObservers() {
        viewModel.newsFormated.observe(this) {
            newsAdapter.submitList(it)
        }

        viewModel.showError.observe(this) {
            showMessage(it)
        }

        viewModel.isLoading.observe(this) {
            if (it == true)
                loadingDialog.show()
            else
                loadingDialog.hide()

        }
    }

}