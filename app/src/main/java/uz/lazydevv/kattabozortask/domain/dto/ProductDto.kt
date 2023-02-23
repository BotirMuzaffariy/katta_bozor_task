package uz.lazydevv.kattabozortask.domain.dto

data class ProductDto(
    val attributes: List<Attribute>,
    val brand: String,
    val category: String,
    val id: Int,
    val image: Image,
    val merchant: String,
    val name: String
)