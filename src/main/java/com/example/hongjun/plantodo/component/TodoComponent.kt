package com.example.hongjun.plantodo.component

import com.example.hongjun.plantodo.dto.Todo
import com.example.hongjun.plantodo.module.ApplicationModule
import com.example.hongjun.plantodo.module.TodoModule
import com.example.hongjun.plantodo.view.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(TodoModule::class))
interface TodoComponent {
    fun inject(mainActivity: MainActivity)
}