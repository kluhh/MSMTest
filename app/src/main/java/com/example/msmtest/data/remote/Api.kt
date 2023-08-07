package com.example.msmtest.data.remote

import com.example.msmtest.common.Constants
import com.example.msmtest.data.remote.dto.PeopleModel
import retrofit2.http.GET


interface Api{
    @GET(Constants.END_POINT)
    suspend fun getAllPeople(): PeopleModel

}
