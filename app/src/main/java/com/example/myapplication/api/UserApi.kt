package com.example.myapplication.api

import com.example.myapplication.business.User
import io.reactivex.Single
import retrofit2.http.*

interface UserApi {
    @Headers( "Content-Type: application/json" )
    @POST("api/account/CreateUser/")
    @FormUrlEncoded
    fun getDataForRegistration(@FieldMap body:HashMap<String,String>): Single<User>


    @Headers( "Content-Type: application/json" )
    @POST("/api/account/Login")
    @FormUrlEncoded
    fun getDataForLogin(@FieldMap body:HashMap<String,String>): Single<User>

/*
    @GET("men.json")
    fun getMenCategory(): Single<List<MenCategory>>

    @GET("women.json")
    fun getWomenCategory(): Single<List<WomenCategory>>

    @GET("all.json")
    fun getAllCategory(): Single<List<Category>>*/
}