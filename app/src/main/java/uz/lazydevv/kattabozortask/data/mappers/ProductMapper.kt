package uz.lazydevv.kattabozortask.data.mappers

import uz.lazydevv.kattabozortask.data.models.ProductM
import uz.lazydevv.kattabozortask.domain.dto.product.ProductDto

fun ProductDto.toProductM(): ProductM {
    return ProductM(
        id = this.id.toString(),
        name = this.name,
        brand = this.brand,
        category = this.category,
        merchant = this.merchant,
        attributes = this.attributes,
        imgUrl = this.image.url
    )
}