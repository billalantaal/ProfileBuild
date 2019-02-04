package com.example.myapplication.api

import com.example.myapplication.base.di.DaggerStrike
import com.example.myapplication.business.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject

class ApiManager {
    init {
        DaggerStrike.doSimpleInjection().here(this)

    }

    @Inject
    lateinit var retrofit: Retrofit


    private val userApi = retrofit.create(UserApi::class.java)




    fun getData(categoryData: (User?) -> Unit) {
        val paramObject = hashMapOf<String,Any>()

        paramObject["FirstName"] = "bbb"
        paramObject["LastName"] = "bbb"
        paramObject["Email"] = "irfan@ggggggb.com"
        paramObject["Password"] = "123"
        paramObject["ConfirmPassword"] = "123"


        userApi.getData(paramObject).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy({
            categoryData(null)
        }, {
            categoryData(it)
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