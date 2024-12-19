package com.example.submissionandroidexpert.core.data.source.remote

import com.example.submissionandroidexpert.core.data.source.remote.network.ApiResponse
import com.example.submissionandroidexpert.core.data.source.remote.network.ApiService
import com.example.submissionandroidexpert.core.data.source.remote.response.GameResponseItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    fun getAllGames(): Flowable<ApiResponse<List<GameResponseItem>>> {
        val resultData = PublishSubject.create<ApiResponse<List<GameResponseItem>>>()

        val client = apiService.getGames()

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                val dataArray = response.gameResponse
                resultData.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }
}