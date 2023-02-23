package uz.lazydevv.kattabozortask.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.lazydevv.kattabozortask.data.mappers.toProductM
import uz.lazydevv.kattabozortask.data.models.ProductM
import uz.lazydevv.kattabozortask.data.remote.ApiService
import uz.lazydevv.kattabozortask.domain.repositories.ProductRepo
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepo {

    override fun fetchProducts(): Flow<List<ProductM>> {
        return flow {
            emit(
                apiService.fetchProducts().offers.map {
                    it.toProductM()
                }
            )
        }
    }
}