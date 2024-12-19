package com.example.submissionandroidexpert.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.submissionandroidexpert.core.data.source.local.entity.GameEntity
import io.reactivex.rxjava3.core.Flowable

@Dao
interface TlmDao {
    @Query("SELECT * FROM games")
    fun getAllGame(): Flowable<List<GameEntity>>

    @Query("SELECT * FROM games where isFavorite = 1")
    fun getFavoriteGame(): Flowable<List<GameEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGame(game: List<GameEntity>)

    @Update
    fun updateFavoriteGame(game: GameEntity)

}