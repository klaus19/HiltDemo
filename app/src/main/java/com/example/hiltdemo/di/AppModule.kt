package com.example.hiltdemo.di

import com.example.hiltdemo.Repository.CryptoImpl
import com.example.hiltdemo.Repository.CryptoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCryptoRepository():CryptoRepository = CryptoImpl()
}