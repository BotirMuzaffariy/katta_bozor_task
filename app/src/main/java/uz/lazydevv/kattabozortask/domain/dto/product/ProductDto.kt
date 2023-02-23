package uz.lazydevv.kattabozortask.domain.dto.product

data class ProductDto(
    val attributes: List<Attribute> = emptyList(),
    val brand: String = "",
    val category: String = "",
    val id: Int = 0,
    val image: Image = Image(
        height = 0,
        url = "",
        width = 0
    ),
    val merchant: String = "",
    val name: String = ""
)