package com.winterry.data.repository

import com.winterry.data.datasource.TempDataSource
import com.winterry.domain.model.TempModel
import com.winterry.domain.repository.TempRepository
import javax.inject.Inject

class TempRepositoryImpl @Inject constructor(private val dataSource: TempDataSource): TempRepository {
    override fun getTempModel(): TempModel {
        return dataSource.getTempModel()
    }
}