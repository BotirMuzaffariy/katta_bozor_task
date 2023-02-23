package uz.lazydevv.kattabozortask.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.lazydevv.kattabozortask.data.models.ProductM

interface ProductRepo {

    fun fetchProducts(): Flow<List<ProductM>>

}