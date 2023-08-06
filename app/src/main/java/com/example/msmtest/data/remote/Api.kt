package com.example.msmtest.data.remote

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.example.msmtest.common.Constants
import com.example.msmtest.data.remote.dto.PeopleItemDto
import com.example.msmtest.data.remote.dto.PeopleModel
import com.google.gson.Gson
import retrofit2.http.GET
import javax.inject.Inject


interface Api{
    @GET(Constants.END_POINT)
    fun getAllPeople(): List<PeopleItemDto>

}
