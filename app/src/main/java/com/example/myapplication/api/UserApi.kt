package com.example.myapplication.api

import com.example.myapplication.business.User
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {
    @GET("master.json")
    fun getData(): Single<List<User>>
/*
    @GET("men.json")
    fun getMenCategory(): Single<List<MenCategory>>

    @GET("women.json")
    fun getWomenCategory(): Single<List<WomenCategory>>

    @GET("all.json")
    fun getAllCategory(): Single<List<Category>>*/
}