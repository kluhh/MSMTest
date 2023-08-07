package com.example.msmtest.data.respository

import com.example.msmtest.data.remote.dto.PeopleItemDto
import com.example.msmtest.domain.model.PeopleItemModel

interface Repository {

    suspend fun getPeople(): List<PeopleItemDto>


}

