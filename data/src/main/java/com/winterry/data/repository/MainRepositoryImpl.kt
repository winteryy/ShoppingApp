package com.winterry.data.repository

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.winterry.data.deserializer.BaseModelDeserializer
import com.winterry.domain.model.BaseModel
import com.winterry.domain.model.Product
import com.winterry.domain.repository.MainRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.InputStreamReader
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    ) : MainRepository {
    override fun getModelList(): Flow<List<BaseModel>> = flow {
        val inputStream = context.assets.open("product_list.json")
        val inputStreamReader = InputStreamReader(inputStream)
        val jsonString = inputStreamReader.readText()
        val type = object: TypeToken<List<BaseModel>>() {}.type

        emit(
            GsonBuilder()
            .registerTypeAdapter(BaseModel::class.java, BaseModelDeserializer())
            .create()
            .fromJson(jsonString, type)
        )
    }
}