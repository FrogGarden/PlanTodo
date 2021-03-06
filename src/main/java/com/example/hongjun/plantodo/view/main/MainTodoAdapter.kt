package com.example.hongjun.plantodo.view.main

import android.content.Context
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import com.example.hongjun.plantodo.Application
import com.example.hongjun.plantodo.R
import com.example.hongjun.plantodo.databinding.ItemTodoBinding
import com.example.hongjun.plantodo.dto.Todo


class MainTodoAdapter(context: Context , items: List<Todo>) : RecyclerView.Adapter<MainTodoAdapter.ViewHolder>() {
    private var items : List<Todo> = items
    private var context : Context = context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false)

        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Todo = items.get(position)


        if(item.title!=null){
            holder.title.text = item.title
        }

        if(item.date!=null){
            holder.date.text = item.date.toString()
        }
        holder.id.text = item.id.toString()

        if(item.done!!){
            holder.todo.setBackgroundColor(context.resources.getColor(R.color.isDone))
            holder.done.isChecked = true
        }

        holder.done.setOnClickListener(View.OnClickListener {
            if(holder.done.isChecked){
                item.done = true
                Application.appDatabase.todoDao().update(item)
                holder.todo.setBackgroundColor(context.resources.getColor(R.color.isDone))

            }else if(holder.done.isChecked==false){
                item.done = false
                Application.appDatabase.todoDao().update(item)
                holder.todo.setBackgroundColor(context.resources.getColor(R.color.notDone))
            }
        })



    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val title = itemView.findViewById<TextView>(R.id.todoTitle)
        val date = itemView.findViewById<TextView>(R.id.todoDate)
        val id = itemView.findViewById<TextView>(R.id.todoId)
        val todo = itemView.findViewById<LinearLayout>(R.id.todo)
        val done = itemView.findViewById<CheckBox>(R.id.done)


    }





}
