package com.example.hongjun.plantodo.module

import com.example.hongjun.plantodo.dto.Todo
import dagger.Module
import dagger.Provides

@Module
class TodoModule(private val todo :Todo ) {
    @Provides
    fun providesTodo() = todo


}