package com.example.msmtest.data.respository

import com.example.msmtest.data.remote.dto.PeopleItemDto

interface Repository {

    suspend fun getPeople(): List<PeopleItemDto>


}

