package com.example.msmtest.domain.respository

import com.android.volley.RequestQueue
import com.example.msmtest.data.remote.Api
import com.example.msmtest.data.remote.dto.PeopleItemDto
import com.example.msmtest.data.respository.Repository
import kotlinx.coroutines.suspendCancellableCoroutine

import javax.inject.Inject
import kotlin.coroutines.resumeWithException


class RepositoryImpl @Inject constructor(
    private val api: Api
) : Repository {
    override suspend fun getPeople(): List<PeopleItemDto> {
       return api.getAllPeople()
    }
}