package com.example.submissionandroidexpert.core.di

import com.example.submissionandroidexpert.core.data.TlmRepositoryImpl
import com.example.submissionandroidexpert.core.domain.repository.TlmRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(tlmRepositoryImpl: TlmRepositoryImpl): TlmRepository
}