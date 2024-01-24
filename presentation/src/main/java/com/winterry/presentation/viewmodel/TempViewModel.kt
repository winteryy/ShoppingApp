package com.winterry.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.winterry.domain.model.TempModel
import com.winterry.domain.usecase.TempUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TempViewModel @Inject constructor(private val useCase: TempUseCase): ViewModel() {

    fun getTempModel(): TempModel {
        return useCase.getTempModel()
    }
}