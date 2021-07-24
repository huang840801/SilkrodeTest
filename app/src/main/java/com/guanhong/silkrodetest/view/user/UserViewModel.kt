package com.guanhong.silkrodetest.view.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guanhong.silkrodetest.ApiService
import com.guanhong.silkrodetest.User
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserViewModel : ViewModel() {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    var userList = MutableLiveData<List<User>>()

    fun getUserList(perPage: Int, fromId: Int) {

        apiService.getUserList(perPage, fromId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<List<User>>> {

                override fun onSubscribe(d: Disposable) {}
                override fun onError(e: Throwable) {}

                override fun onSuccess(response: Response<List<User>>) {

                    userList.value = userList.value?.toMutableList().orEmpty() + response.body()!!
                }
            })
    }
}