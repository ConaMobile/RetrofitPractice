package com.conamobile.requestapigetmethod

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.conamobile.requestapigetmethod.adapter.UserAdapter
import com.conamobile.requestapigetmethod.databinding.ActivityMainBinding
import com.conamobile.requestapigetmethod.model.User
import com.conamobile.requestapigetmethod.networking.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var userList = ArrayList<User>()
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()
    }

    private fun initViews() {
        loadData()
    }

    private fun loadData() {
        RetrofitHttp.posterService.listUsers()
            .enqueue(object : Callback<ArrayList<User>> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>
                ) {
                    userList.addAll(response.body()!!)
                    setupAdapter()
                }

                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {}
            })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupAdapter() {
        userAdapter = UserAdapter(this, userList)
        binding.recyclerView.adapter = userAdapter
    }
}