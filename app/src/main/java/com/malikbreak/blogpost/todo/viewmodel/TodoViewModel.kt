package com.malikbreak.blogpost.todo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malikbreak.blogpost.todo.api.TodosClient
import com.malikbreak.blogpost.todo.model.TodoModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoViewModel : ViewModel() {

    var todoMutableLiveData= MutableLiveData<List<TodoModelItem>>()

    fun getTodos(){
        TodosClient.TodoApi.getTodos().enqueue(object : Callback<List<TodoModelItem>>{
            override fun onResponse(
                call: Call<List<TodoModelItem>>,
                response: Response<List<TodoModelItem>>
            ) {
                todoMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<TodoModelItem>>, t: Throwable) {
                return t.printStackTrace()
            }

        })
    }
}