package com.example.hongjun.plantodo.view.todo


import android.app.DatePickerDialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.hongjun.plantodo.Application
import com.example.hongjun.plantodo.R
import com.example.hongjun.plantodo.databinding.ActivityTodoCreateBinding
import com.example.hongjun.plantodo.dto.Todo

class TodoCreateActivity : AppCompatActivity(){
    private lateinit var binding : ActivityTodoCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo_create)

        //viewModel
        binding.todoDate.setOnClickListener(View.OnClickListener {

        })

        binding.cancel.setOnClickListener(View.OnClickListener {
            finish()
        })

        binding.create.setOnClickListener(View.OnClickListener {
            var title = binding.todoTitle.hint.toString()
            if(!binding.todoTitle.text.isEmpty()){
                title = binding.todoTitle.text.toString()
            }
            var todo = Todo(title,
                    binding.todoContent.text.toString(),
                    binding.todoDate.text.toString())
            Application.appDatabase.todoDao().create(todo)
            finish()
        })


    }
}