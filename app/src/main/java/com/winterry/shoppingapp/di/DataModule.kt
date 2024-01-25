package com.winterry.shoppingapp.di

import com.winterry.data.repository.MainRepositoryImpl
import com.winterry.data.repository.TempRepositoryImpl
import com.winterry.domain.repository.MainRepository
import com.winterry.domain.repository.TempRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindTempRepository(tempRepositoryImpl: TempRepositoryImpl): TempRepository

    @Binds
    @Singleton
    fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}