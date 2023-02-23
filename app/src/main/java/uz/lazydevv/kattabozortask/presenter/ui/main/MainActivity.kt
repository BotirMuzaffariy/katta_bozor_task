package uz.lazydevv.kattabozortask.presenter.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.lazydevv.kattabozortask.R
import uz.lazydevv.kattabozortask.databinding.ActivityMainBinding
import uz.lazydevv.kattabozortask.presenter.ui.adapters.RvProductsAdapter
import uz.lazydevv.kattabozortask.presenter.utils.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val viewModel by viewModels<MainActivityViewModel>()

    private val productsAdapter by lazy { RvProductsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchProducts()

        observeProducts()

        with(binding) {
            rvProducts.adapter = productsAdapter
        }
    }

    private fun observeProducts() {
        with(binding) {
            viewModel.products.observe(this@MainActivity) { result ->
                when (result) {
                    is Resource.Loading -> {
                        pbLoading.isVisible = true
                        rvProducts.isVisible = false
                        tvMsg.isVisible = false
                    }

                    is Resource.Empty -> {
                        pbLoading.isVisible = false
                        rvProducts.isVisible = false
                        tvMsg.isVisible = true

                        tvMsg.text = getString(R.string.emptyMsg)
                    }

                    is Resource.Error -> {
                        pbLoading.isVisible = false
                        rvProducts.isVisible = false
                        tvMsg.isVisible = true

                        tvMsg.text = getString(R.string.errorMsg)
                    }

                    is Resource.Success -> {
                        pbLoading.isVisible = false
                        rvProducts.isVisible = true
                        tvMsg.isVisible = false

                        productsAdapter.diffUtil.submitList(result.data)
                    }
                }
            }
        }
    }

}