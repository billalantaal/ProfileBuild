package com.example.myapplication.api

import com.example.myapplication.business.User
import io.reactivex.Single
import retrofit2.http.*

interface UserApi {
    @POST("api/account/CreateUser/")
    @FormUrlEncoded
    fun getData(@FieldMap body:HashMap<String,Any>): Single<User>
/*
    @GET("men.json")
    fun getMenCategory(): Single<List<MenCategory>>

    @GET("women.json")
    fun getWomenCategory(): Single<List<WomenCategory>>

    @GET("all.json")
    fun getAllCategory(): Single<List<Category>>*/
}