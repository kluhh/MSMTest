package com.example.msmtest.data.remote.dto


import com.example.msmtest.domain.model.PeopleItemModel
import com.google.gson.annotations.SerializedName

data class PeopleItemDto(
    @SerializedName("avatarImage")
    val avatarImage: String? = "",
    @SerializedName("dateOfBirth")
    val dateOfBirth: String? = "",
    @SerializedName("firstName")
    val firstName: String? = "",
    @SerializedName("lastName")
    val lastName: String? = "",
    @SerializedName("role")
    val role: String? = ""
)

fun PeopleItemDto.toPeopleItem(): PeopleItemModel {
    return PeopleItemModel(
        avatarImage = avatarImage.orEmpty(),
        dateOfBirth = dateOfBirth.orEmpty(),
        firstName = firstName.orEmpty(),
        lastName = lastName.orEmpty(),
        role = role.orEmpty()
    )
}