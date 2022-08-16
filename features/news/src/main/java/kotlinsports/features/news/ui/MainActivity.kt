package kotlinsports.features.news.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinsports.features.news.R
import kotlinsports.ui_components.externsions.createLoadingDialog
import kotlinsports.ui_components.externsions.showMessage
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private val loadingDialog by lazy {
        createLoadingDialog()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setupView()
        setupObservers()

        viewModel.init()
    }

    private fun setupView() {
        //rvCards.adapter = cardsAdapter
    }

    private fun setupObservers() {
        viewModel.news.observe(this) {
            //newsAdapter.submitList(it)
            Log.d("API", it.toString())
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