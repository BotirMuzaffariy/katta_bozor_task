package uz.lazydevv.kattabozortask.presenter.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.lazydevv.kattabozortask.data.models.ProductM
import uz.lazydevv.kattabozortask.presenter.utils.Resource

class MainActivityViewModel : ViewModel() {

    val products: LiveData<Resource<List<ProductM>>> get() = _products
    private val _products = MutableLiveData<Resource<List<ProductM>>>()

    fun fetchProducts() {
        //
    }
}