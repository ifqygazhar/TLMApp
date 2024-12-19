package com.example.submissionandroidexpert.core.data.source.local

import com.example.submissionandroidexpert.core.data.source.local.entity.GameEntity
import com.example.submissionandroidexpert.core.data.source.local.room.TlmDao
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val tlmDao: TlmDao) {
    fun getAllGame(): Flowable<List<GameEntity>> = tlmDao.getAllGame()
    fun getFavoriteGame(): Flowable<List<GameEntity>> = tlmDao.getFavoriteGame()
    fun insertGame(gameList: List<GameEntity>) = tlmDao.insertGame(gameList)
    fun setFavoriteGame(game: GameEntity, newState: Boolean) {
        game.isFavorite = newState
        tlmDao.updateFavoriteGame(game)
    }
}