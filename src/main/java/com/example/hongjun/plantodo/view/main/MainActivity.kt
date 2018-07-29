package com.example.hongjun.plantodo.view.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.hongjun.plantodo.Application
import com.example.hongjun.plantodo.R
import com.example.hongjun.plantodo.databinding.ActivityMainBinding
import com.example.hongjun.plantodo.databinding.ActivityTodoCreateBinding
import com.example.hongjun.plantodo.dto.Todo
import com.example.hongjun.plantodo.view.todo.TodoCreateActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //viewModel 에서 처리 될 로직
        binding.root.createTodo.setOnClickListener(View.OnClickListener {

            startActivity(Intent(this, TodoCreateActivity::class.java))
        })

        binding.root.deleteTodo.setOnClickListener(View.OnClickListener {
            Application.appDatabase.todoDao().delete(true)

            init()
        })

        binding.root.todoList.setHasFixedSize(true)
        binding.root.todoList.layoutManager = LinearLayoutManager(this)
        binding.root.todoList.adapter = MainTodoAdapter(this, Application.appDatabase.todoDao().findAll())

    }

    override fun onResume() {
        super.onResume()

        init()

    }

    fun init(){
        binding.root.todoList.adapter = MainTodoAdapter(this, Application.appDatabase.todoDao().findAll())
    }




}

