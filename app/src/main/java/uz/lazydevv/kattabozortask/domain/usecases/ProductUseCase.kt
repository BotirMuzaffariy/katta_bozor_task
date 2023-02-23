package uz.lazydevv.kattabozortask.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.lazydevv.kattabozortask.data.models.ProductM
import uz.lazydevv.kattabozortask.domain.repositories.ProductRepo
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val productRepo: ProductRepo
) {

    fun fetchProducts(): Flow<List<ProductM>> {
        return productRepo.fetchProducts().flowOn(Dispatchers.IO)
    }

}