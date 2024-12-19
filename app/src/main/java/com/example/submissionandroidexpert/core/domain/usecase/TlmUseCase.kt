package com.example.submissionandroidexpert.core.domain.usecase

import com.example.submissionandroidexpert.core.data.Resource
import com.example.submissionandroidexpert.core.domain.model.Game
import io.reactivex.rxjava3.core.Flowable

interface TlmUseCase {
    fun getAllGame(): Flowable<Resource<List<Game>>>
    fun getFavoriteGame(): Flowable<List<Game>>
    fun setFavoriteGame(game: Game, state: Boolean)
}