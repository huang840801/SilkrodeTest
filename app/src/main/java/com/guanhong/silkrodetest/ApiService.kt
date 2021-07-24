package com.guanhong.silkrodetest

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUserList(): Single<Response<List<User>>>
}