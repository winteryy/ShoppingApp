package com.winterry.domain.usecase

import com.winterry.domain.model.BaseModel
import com.winterry.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun getModelList(): Flow<List<BaseModel>> {
        return mainRepository.getModelList()
    }
}