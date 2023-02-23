package uz.lazydevv.kattabozortask.data.models

import uz.lazydevv.kattabozortask.domain.dto.Attribute

data class ProductM(
    val id: String,
    val name: String,
    val brand: String,
    val category: String,
    val merchant: String,
    val attributes: List<Attribute>,
    val imgUrl: String
)
