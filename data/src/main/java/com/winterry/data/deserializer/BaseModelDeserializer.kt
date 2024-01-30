package com.winterry.data.deserializer

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.winterry.domain.model.Banner
import com.winterry.domain.model.BannerList
import com.winterry.domain.model.BaseModel
import com.winterry.domain.model.Carousel
import com.winterry.domain.model.ModelType
import com.winterry.domain.model.Product
import java.lang.reflect.Type

class BaseModelDeserializer: JsonDeserializer<BaseModel> {
    companion object {
        private const val TYPE = "type"
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): BaseModel {
        val root = json?.asJsonObject
        val gson = GsonBuilder().create()

        val typeString = root?.get(TYPE)?.asString ?: ""

        return when(ModelType.valueOf(typeString)) {
            ModelType.BANNER -> gson.fromJson(root, Banner::class.java)
            ModelType.PRODUCT -> gson.fromJson(root, Product::class.java)
            ModelType.BANNER_LIST -> gson.fromJson(root, BannerList::class.java)
            ModelType.CAROUSEL -> gson.fromJson(root, Carousel::class.java)
        }
    }
}