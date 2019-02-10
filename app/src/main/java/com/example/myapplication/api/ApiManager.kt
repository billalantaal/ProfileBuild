package com.example.myapplication.api

import android.util.Log
import com.example.myapplication.base.di.DaggerStrike
import com.example.myapplication.business.User
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject


class ApiManager {
    init {
        DaggerStrike.doSimpleInjection().here(this)

    }

    @Inject
    lateinit var retrofit: Retrofit


    private val userApi = retrofit.create(UserApi::class.java)


    fun postDataToRegisterAPI( firstName:String,
                               lastName:String,
                               email:String,
                               password:String,
                               confirmPassword:String,
                              registerData: (User?) -> Unit) {
//        val paramObject = hashMapOf<String,String>()

        val paramObject = JsonObject()
        paramObject.addProperty("FirstName", firstName)
        paramObject.addProperty("LastName", lastName)
        paramObject.addProperty("Email", email)
        paramObject.addProperty("Password", password)
        paramObject.addProperty("ConfirmPassword", confirmPassword)
//        paramObject.put("RoleId",1)

        userApi.getDataForRegistration(paramObject).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribeBy({
            registerData(null)

        }, {
            registerData(it)
        })
    }


    fun postDataToLoginAPI(loginData: (User?) -> Unit) {
        val jasonparams = hashMapOf<String, String>()
        jasonparams["UserName"] = "irfan@ggggggb.com"
        jasonparams["Password"] = "123"

        userApi.getDataForLogin(jasonparams).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribeBy({
                loginData(null)
            }, {
                loginData(it)
            })
    }


/*    fun getCategories(data: (Categories?) -> Unit): Disposable {
        return Single.zip(
            userApi.getAllCategory(),
            userApi.getMenCategory(),
            userApi.getWomenCategory(),
            Function3<List<Category>, List<MenCategory>, List<WomenCategory>, Categories> { t1, t2, t3 ->
                Categories(t1, t2, t3)
            }


        ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy({
            data(null)
        }, {
            data(it)
        })
    }*/


}