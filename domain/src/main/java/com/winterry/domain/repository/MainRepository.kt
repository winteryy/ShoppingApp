package com.winterry.domain.repository

import com.winterry.domain.model.Product

interface MainRepository {
    fun getProductList(): List<Product>
}