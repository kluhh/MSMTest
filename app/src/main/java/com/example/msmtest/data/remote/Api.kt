package com.example.msmtest.data.remote

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.example.msmtest.common.Constants
import com.example.msmtest.data.remote.dto.PeopleItemDto
import com.google.gson.Gson


class Api(private val requestQueue: RequestQueue) {
    fun getPeople(callback: (PeopleItemDto) -> Unit) {
        val url = Constants.END_POINT // Update with the correct endpoint for drivers
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val peopleItems = Gson().fromJson(response, PeopleItemDto::class.java)
                callback(peopleItems)
            },
            { /* Handle error here */ }
        )
        requestQueue.add(stringRequest)
    }
}