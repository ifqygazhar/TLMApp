package com.example.submissionandroidexpert.core.data

import com.example.submissionandroidexpert.core.data.source.local.LocalDataSource
import com.example.submissionandroidexpert.core.data.source.remote.RemoteDataSource
import com.example.submissionandroidexpert.core.data.source.remote.network.ApiResponse
import com.example.submissionandroidexpert.core.data.source.remote.response.GameResponseItem
import com.example.submissionandroidexpert.core.domain.model.Game
import com.example.submissionandroidexpert.core.domain.repository.TlmRepository
import com.example.submissionandroidexpert.core.utils.AppExecutors
import com.example.submissionandroidexpert.core.utils.DataMapper
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TlmRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : TlmRepository {
    override fun getAllGame(): Flowable<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<GameResponseItem>>() {
            override fun loadFromDB(): Flowable<List<Game>> {
                return localDataSource.getAllGame().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean = data.isNullOrEmpty()

            override fun createCall(): Flowable<ApiResponse<List<GameResponseItem>>> =
                remoteDataSource.getAllGames()

            override fun saveCallResult(data: List<GameResponseItem>) {
                val gameList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGame(gameList)
            }
        }.asFlowable()

    override fun getFavoriteGame(): Flowable<List<Game>> {
        return localDataSource.getFavoriteGame().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteGame(game: Game, state: Boolean) {
        val gameEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGame(gameEntity, state) }
    }

}