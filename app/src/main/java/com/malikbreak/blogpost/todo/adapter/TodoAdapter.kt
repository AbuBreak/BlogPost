package com.malikbreak.blogpost.todo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.malikbreak.blogpost.R
import com.malikbreak.blogpost.comment.model.CommentModelItem
import com.malikbreak.blogpost.todo.model.TodoModelItem

class TodoAdapter(
    private var context: Context,
    private var todos: List<TodoModelItem>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.todoId.text = todos[position].id.toString()
        holder.title.text = todos[position].title
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTodoList(todos: List<TodoModelItem>){
        this.todos = todos
        notifyDataSetChanged()
    }

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val todoId : TextView = itemView.findViewById(R.id.todoIdTV)
        val title : TextView = itemView.findViewById(R.id.titleTV)
        val completedTodo : CheckBox = itemView.findViewById(R.id.completedCB)
        val CardView : CardView = itemView.findViewById(R.id.todoCardView)
    }


}