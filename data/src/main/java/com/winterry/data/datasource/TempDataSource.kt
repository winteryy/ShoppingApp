package com.winterry.data.datasource

import com.winterry.domain.model.TempModel
import javax.inject.Inject

class TempDataSource @Inject constructor() {
    fun getTempModel(): TempModel {
        return TempModel("testModel")
    }
}