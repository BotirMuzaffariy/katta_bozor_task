package uz.lazydevv.kattabozortask.domain.dto

import uz.lazydevv.kattabozortask.domain.dto.product.ProductDto

data class OffersDto(
    val offers: List<ProductDto> = emptyList()
)
