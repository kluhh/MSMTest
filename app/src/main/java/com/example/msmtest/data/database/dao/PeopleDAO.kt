package com.example.msmtest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.msmtest.data.remote.dto.PeopleItemDto

@Dao
interface PeopleDAO {

    @Query("select * from People")
    fun getAllPeople(): List<PeopleItemDto>

    @Upsert
    fun insertPeople(people: PeopleItemDto): Long

    @Upsert
    suspend fun insertAll(people: List<PeopleItemDto>)

//    @Query("select * from People where id=:id")
//    fun selectPeopleById(id: Int)
}