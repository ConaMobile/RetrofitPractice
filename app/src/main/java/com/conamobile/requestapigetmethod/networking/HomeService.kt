package com.conamobile.requestapigetmethod.networking

import com.conamobile.requestapigetmethod.model.User
import retrofit2.Call
import retrofit2.http.GET

interface HomeService {

    @GET("/users")
    fun listUsers(): Call<ArrayList<User>>
}