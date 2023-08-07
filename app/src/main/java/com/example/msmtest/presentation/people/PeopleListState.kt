package com.example.msmtest.presentation.people

import com.example.msmtest.domain.model.PeopleItemModel

data class PeopleListState(
    val people: List<PeopleItemModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
