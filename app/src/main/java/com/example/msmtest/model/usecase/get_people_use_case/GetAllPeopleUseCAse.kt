package com.example.msmtest.model.usecase.get_people_use_case

import android.util.Log
import com.example.msmtest.common.Resource
import com.example.msmtest.data.remote.dto.toPeopleItem
import com.example.msmtest.data.respository.Repository
import com.example.msmtest.domain.model.PeopleItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

const val TAG ="GetAllPeopleUseCAse:"

class GetAllPeopleUseCAse @Inject constructor(val repository: Repository){

    operator fun invoke() : Flow<Resource<List<PeopleItemModel>>> = flow {


        try {
            emit(Resource.Loading<List<PeopleItemModel>>())
            val peopleList = repository.getPeople().map{it.toPeopleItem()}
            emit(Resource.Success<List<PeopleItemModel>>(peopleList))
        }
        catch (e: HttpException){
            Log.e(TAG, "unexpected error occurred")
            emit(Resource.Error<List<PeopleItemModel>>("unexpected error occurred"))
        }
        catch (e: IOException){
            Log.e(TAG, "Couldn't reach the server please make sure your internet is on")
            emit(Resource.Error<List<PeopleItemModel>>("Couldn't reach the server please make sure your internet is on"))

        }



    }


}
