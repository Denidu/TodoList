package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R.layout.item_todo

class TodoAdapter (
    private val todos: MutableList<Todo>

):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_todo,
                parent,
                false
            )
        )
    }

    fun addTodo(todo:Todo){
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }
    fun deleteTodos(){
        todos.removeAll{todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean){
        if(isChecked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.itemView.apply {
        }
    }

    override fun getItemCount(): Int {
        return todos.size

    }
}
