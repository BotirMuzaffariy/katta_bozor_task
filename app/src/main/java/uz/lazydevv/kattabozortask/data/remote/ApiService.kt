package uz.lazydevv.kattabozortask.data.remote

import retrofit2.http.GET
import uz.lazydevv.kattabozortask.domain.dto.OffersDto

interface ApiService {

    @GET("offers")
    suspend fun fetchProducts(): OffersDto

}