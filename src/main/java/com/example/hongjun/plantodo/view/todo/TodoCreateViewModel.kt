package com.example.hongjun.plantodo.view.todo

import android.content.Context
import android.util.Log
import android.view.View
import com.example.hongjun.plantodo.Application
import com.example.hongjun.plantodo.R
import com.example.hongjun.plantodo.databinding.ActivityTodoCreateBinding
import com.example.hongjun.plantodo.dto.Todo


class TodoCreateViewModel(context: Context, binding : ActivityTodoCreateBinding) : TodoCreateActivity() {
    private var context = context
    private var binding = binding

    override fun onClick(v: View){
        when(v.id){
            R.id.todoDate ->{

            }
            R.id.cancel ->{
                finish()
            }
            R.id.create ->{
                var title = binding.todoTitle.hint.toString()
                if(!binding.todoTitle.text.isEmpty()){
                    title = binding.todoTitle.text.toString()
                }
                var todo = Todo(title,
                        binding.todoContent.text.toString(),
                        binding.todoDate.text.toString())
                Application.appDatabase.todoDao().create(todo)
                finish()
            }
        }
    }
}