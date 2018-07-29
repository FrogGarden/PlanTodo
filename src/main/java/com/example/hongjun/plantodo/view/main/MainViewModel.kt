package com.example.hongjun.plantodo.view.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.hongjun.plantodo.Application
import com.example.hongjun.plantodo.R
import com.example.hongjun.plantodo.databinding.ActivityMainBinding
import com.example.hongjun.plantodo.view.todo.TodoCreateActivity

class MainViewModel(context: Context, binding : ActivityMainBinding){
    private var context = context
    private var binding = binding




    fun onClick(v : View){
        when(v.id){
            R.id.createTodo ->{
                startActivity(context, Intent(context, TodoCreateActivity::class.java), null)


            }
            R.id.deleteTodo ->{
                Application.appDatabase.todoDao().delete(true)
                binding.todoList.adapter = MainTodoAdapter(context, Application.appDatabase.todoDao().findAll())

            }
        }

    }



}