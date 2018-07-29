package com.example.hongjun.plantodo.module

import com.example.hongjun.plantodo.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplication() = application
}