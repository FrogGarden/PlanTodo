package com.example.hongjun.plantodo.view.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.hongjun.plantodo.Application
import com.example.hongjun.plantodo.R
import com.example.hongjun.plantodo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = MainViewModel(this, binding)


        setupView()

        //onClick /databinding
//        binding.createTodo.setOnClickListener(View.OnClickListener {
//
//            startActivity(Intent(this, TodoCreateActivity::class.java))
//        })
//
//        binding.deleteTodo.setOnClickListener(View.OnClickListener {
//            Application.appDatabase.todoDao().delete(true)
//
//            init()
//        })




    }

    override fun onResume() {
        super.onResume()
        init()

    }

    fun setupView(){
        binding.todoList.setHasFixedSize(true)
        binding.todoList.layoutManager = LinearLayoutManager(this)
        init()
    }

    fun init(){
        binding.todoList.adapter = MainTodoAdapter(this, Application.appDatabase.todoDao().findAll())
    }

    //viewModel
//    fun onClick(v : View){
//        when(v.id){
//            R.id.createTodo ->{
//                startActivity(Intent(this, TodoCreateActivity::class.java))
//            }
//            R.id.deleteTodo ->{
//                Application.appDatabase.todoDao().delete(true)
//                init()
//            }
//        }
//    }




}

