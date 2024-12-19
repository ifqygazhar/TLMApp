package com.example.submissionandroidexpert.core.domain.usecase

import com.example.submissionandroidexpert.core.domain.model.Game
import com.example.submissionandroidexpert.core.domain.repository.TlmRepository
import io.reactivex.rxjava3.core.Flowable

class TlmInteractor(private val tlmRepository: TlmRepository) : TlmUseCase {
    override fun getAllGame() = tlmRepository.getAllGame()
    override fun getFavoriteGame(): Flowable<List<Game>> = tlmRepository.getFavoriteGame()

    override fun setFavoriteGame(game: Game, state: Boolean) =
        tlmRepository.setFavoriteGame(game, state)

}