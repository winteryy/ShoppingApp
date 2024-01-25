package com.winterry.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.winterry.data.db.converter.BasketConverter
import com.winterry.domain.model.Category
import com.winterry.domain.model.Price
import com.winterry.domain.model.Product
import com.winterry.domain.model.Shop

@Entity(tableName = "basket")
@TypeConverters(BasketConverter::class)
data class BasketProductEntity (
    @PrimaryKey
    val productId: String,
    val productName: String,
    val imageUrl: String,
    val price: Price,
    val category: Category,
    val shop: Shop,
    val isNew: Boolean,
    val isFreeShipping: Boolean
)

fun BasketProductEntity.toDomainModel(): Product {
     return Product(
         productId = productId,
         productName = productName,
         imageUrl = imageUrl,
         price = price,
         category = category,
         shop = shop,
         isNew = isNew,
         isFreeShipping = isFreeShipping
     )
}