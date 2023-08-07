package com.example.msmtest.presentation.people

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msmtest.common.Resource
import com.example.msmtest.model.usecase.get_people_use_case.GetAllPeopleUseCAse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getAllPeopleUseCase: GetAllPeopleUseCAse) : ViewModel() {

    private val _state = mutableStateOf(PeopleListState())
    val state = _state

    init {
        getAllPeople()
    }

    private fun getAllPeople() {
        getAllPeopleUseCase().onEach { result ->
        when(result){
            is Resource.Success -> {
                _state.value = PeopleListState(result.data?: emptyList())
            }
            is Resource.Loading -> {
                _state.value = PeopleListState(isLoading = true)
            }
            is Resource.Error -> {
                _state.value = PeopleListState(error= result.message ?: "Unexpected error occurred")
            }

            else -> {}
        }

        }.launchIn(viewModelScope)
    }
}