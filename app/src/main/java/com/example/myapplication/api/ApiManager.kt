package com.example.myapplication.api

import com.example.myapplication.base.di.DaggerStrike
import com.example.myapplication.business.User
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


    fun getData(categoryData: (List<User>?) -> Unit) {
        userApi.getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy({
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