package com.malikbreak.blogpost.user.viewmdoel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malikbreak.blogpost.user.api.UserInterface
import com.malikbreak.blogpost.user.api.UsersClient
import com.malikbreak.blogpost.user.model.UserModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    var usersMutableLiveData = MutableLiveData<List<UserModelItem>>()

    fun getUsers(){
        UsersClient.UsersApi.getUsers().enqueue(object :Callback<List<UserModelItem>>{
            override fun onResponse(
                call: Call<List<UserModelItem>>,
                response: Response<List<UserModelItem>>
            ) {
                usersMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<UserModelItem>>, t: Throwable) {
                return t.printStackTrace()
            }

        })
    }
}