package com.example.submissionandroidexpert.core.data.source.remote.network

import com.example.submissionandroidexpert.core.data.source.remote.response.DetailResponse
import com.example.submissionandroidexpert.core.data.source.remote.response.GameResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("games")
    fun getGames(): Flowable<GameResponse>

    @GET("detail/{key}")
    fun getDetail(key: String): Flowable<DetailResponse>
}