package com.example.submissionandroidexpert.core.di

import android.content.Context
import com.example.submissionandroidexpert.core.domain.repository.TlmRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): TlmRepository
}