package com.winterry.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.winterry.data.db.dao.BasketDao
import com.winterry.data.db.dao.LikeDao
import com.winterry.data.db.dao.PurchaseDao
import com.winterry.data.db.entity.BasketProductEntity
import com.winterry.data.db.entity.LikeProductEntity
import com.winterry.data.db.entity.PurchaseProductEntity

@Database(
    entities = [
        PurchaseProductEntity::class,
        LikeProductEntity::class,
        BasketProductEntity::class
    ],
    version = 1
)
abstract class ApplicationDataBase: RoomDatabase() {
    companion object {
        const val DB_NAME = "ApplicationDatabase.db"
    }

    abstract fun purchaseDao(): PurchaseDao

    abstract fun likeDao(): LikeDao

    abstract fun basketDao(): BasketDao
}