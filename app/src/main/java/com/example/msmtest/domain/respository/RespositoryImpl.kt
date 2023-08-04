package com.example.msmtest.domain.respository

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.example.msmtest.common.Constants
import com.example.msmtest.data.remote.Api
import com.example.msmtest.data.remote.dto.PeopleItemDto
import com.example.msmtest.data.respository.Repository
import com.google.gson.Gson
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class RepositoryImpl @Inject constructor(
    private val requestQueue: RequestQueue,
    private val Api: Api
) : Repository {



    override suspend fun getPeople(): List<PeopleItemDto> = suspendCancellableCoroutine { continuation ->
        val url = Constants.END_POINT
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val peopleItems = Gson().fromJson(response,Array<PeopleItemDto>::class.java).toList()
                continuation.resume(peopleItems) // Resume the coroutine with the result
            },
            { error ->
                continuation.resumeWithException(error) // Resume the coroutine with an exception
            }
        )
        requestQueue.add(stringRequest)
    }

}