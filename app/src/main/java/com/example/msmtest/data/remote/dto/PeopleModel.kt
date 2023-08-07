package com.example.msmtest.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PeopleModel(
    @SerializedName("people")
    val people: List<PeopleItemDto>?
)