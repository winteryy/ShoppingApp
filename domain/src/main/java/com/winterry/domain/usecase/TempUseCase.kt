package com.winterry.domain.usecase

import com.winterry.domain.model.TempModel
import com.winterry.domain.repository.TempRepository
import javax.inject.Inject

class TempUseCase @Inject constructor(private val repository: TempRepository) {

    fun getTempModel(): TempModel {
        return repository.getTempModel()
    }
}