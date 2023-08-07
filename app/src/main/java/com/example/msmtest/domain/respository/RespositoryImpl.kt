package com.example.msmtest.domain.respository

import android.content.Context
import com.example.msmtest.data.database.dao.PeopleDAO
import com.example.msmtest.data.remote.Api
import com.example.msmtest.data.remote.dto.PeopleItemDto
import com.example.msmtest.data.respository.Repository
import com.example.msmtest.util.InternetConnectivityHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val api: Api, private val peopleDAO: PeopleDAO, private val context: Context
) : Repository {
    override suspend fun getPeople(): List<PeopleItemDto> {
        val isInternetConnected = InternetConnectivityHelper.isInternetAvailable(context)

        if (isInternetConnected) {
            val apiPeople = api.getAllPeople().people ?: emptyList()
            val dbPeople = withContext(Dispatchers.IO) {
                peopleDAO.getAllPeople()
            }

            if (dbPeople.isEmpty()) {
                withContext(Dispatchers.IO) {
                    peopleDAO.insertAll(apiPeople)
                }
            }

            return if (dbPeople.isEmpty()) {
                apiPeople
            } else {
                dbPeople
            }
        } else {
            return withContext(Dispatchers.IO) {
                peopleDAO.getAllPeople()
            }
        }
    }


}