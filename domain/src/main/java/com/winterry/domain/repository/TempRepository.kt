package com.winterry.domain.repository

import com.winterry.domain.model.TempModel

interface TempRepository {
    fun getTempModel(): TempModel
}