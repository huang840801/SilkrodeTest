package com.guanhong.silkrodetest

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUserList(
        @Query("per_page") perPage: Int,
        @Query("since") fromId: Int
    ): Single<Response<List<User>>>
}