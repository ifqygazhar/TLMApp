package com.example.submissionandroidexpert.core.utils

import com.example.submissionandroidexpert.core.data.source.local.entity.GameEntity
import com.example.submissionandroidexpert.core.data.source.remote.response.GameResponseItem
import com.example.submissionandroidexpert.core.domain.model.Game

object DataMapper {
    fun mapResponsesToEntities(input: List<GameResponseItem>): List<GameEntity> {
        val gameList = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                key = it.key,
                thumb = it.thumb,
                author = it.author,
                tag = it.tag,
                time = it.time,
                title = it.title,
                desc = it.desc,
                isFavorite = false
            )
        }
        return gameList
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                thumb = it.thumb,
                author = it.author,
                tag = it.tag,
                time = it.time,
                title = it.title,
                key = it.key,
                desc = it.desc,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) = GameEntity(
        key = input.key,
        thumb = input.thumb,
        author = input.author,
        tag = input.tag,
        time = input.time,
        title = input.title,
        desc = input.desc,
        isFavorite = input.isFavorite
    )
}