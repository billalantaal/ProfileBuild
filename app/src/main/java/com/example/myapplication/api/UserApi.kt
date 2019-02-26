package com.example.myapplication.api

import com.example.myapplication.business.Forms
import com.example.myapplication.business.User
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserApi {
    @Headers("Content-Type: application/json")
    @POST("api/Account/CreateUser")
//    @FormUrlEncoded
    fun getDataForRegistration(@Body body: JsonObject): Single<User>


    @Headers("Content-Type: application/json")
    @POST("api/Account/CreatePassword")
//    @FormUrlEncoded
    fun getDataForPassword(@Body body: JsonObject): Single<User>

    @Headers("Content-Type: application/json")
    @POST("/api/account/Login")
    fun getDataForLogin(@Body body: JsonObject): Single<User>


    @Headers("Content-Type: application/json")
    @GET("/api/Forms/Get")
    fun getDataForForms(): Single<Forms>
/*
    @GET("men.json")
    fun getMenCategory(): Single<List<MenCategory>>

    @GET("women.json")
    fun getWomenCategory(): Single<List<WomenCategory>>

    @GET("all.json")
    fun getAllCategory(): Single<List<Category>>*/
}