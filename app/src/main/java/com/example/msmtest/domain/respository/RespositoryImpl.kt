package com.example.msmtest.domain.respository

import com.example.msmtest.data.remote.Api
import com.example.msmtest.data.respository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: Api): Repository {
//    override suspend fun getDrivers(): ServerResponse {
//        return api.getDrivers()
//    }
//
//    override suspend fun getRoute(): ServerResponse {
//        return api.getRoutes()
//    }
}