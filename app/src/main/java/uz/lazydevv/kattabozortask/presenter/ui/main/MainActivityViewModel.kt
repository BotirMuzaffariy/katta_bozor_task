package uz.lazydevv.kattabozortask.presenter.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import uz.lazydevv.kattabozortask.data.models.ProductM
import uz.lazydevv.kattabozortask.domain.usecases.ProductUseCase
import uz.lazydevv.kattabozortask.presenter.utils.Resource
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val productUseCase: ProductUseCase
) : ViewModel() {

    val products: LiveData<Resource<List<ProductM>>> get() = _products
    private val _products = MutableLiveData<Resource<List<ProductM>>>()

    fun fetchProducts() {
        productUseCase.fetchProducts()
            .onStart {
                _products.postValue(Resource.Loading())
            }
            .onEach { products ->
                if (products.isNotEmpty()) {
                    _products.postValue(Resource.Success(products))
                } else {
                    _products.postValue(Resource.Empty())
                }
            }
            .catch {
                _products.postValue(Resource.Error(it.message))
            }
            .launchIn(viewModelScope)
    }
}