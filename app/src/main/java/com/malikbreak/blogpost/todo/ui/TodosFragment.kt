package com.malikbreak.blogpost.todo.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikbreak.blogpost.core.base.BaseFragment
import com.malikbreak.blogpost.databinding.FragmentTodosBinding
import com.malikbreak.blogpost.todo.adapter.TodoAdapter
import com.malikbreak.blogpost.todo.model.TodoModelItem
import com.malikbreak.blogpost.todo.viewmodel.TodoViewModel


class TodosFragment : BaseFragment<FragmentTodosBinding>() {
    private lateinit var todoViewModel:TodoViewModel
    private lateinit var adapter: TodoAdapter
    private var todos: List<TodoModelItem>? = null


    override fun getViewBinding(): FragmentTodosBinding =
        FragmentTodosBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        todoViewModel.getTodos()
        todos?.let { adapter.setTodoList(it) }

        todoViewModel.todoMutableLiveData.observe(viewLifecycleOwner){
            adapter = TodoAdapter(requireContext(),it)
            binding.todoRecycler.adapter = adapter
            binding.todoRecycler.layoutManager = LinearLayoutManager(activity)
        }

    }

}