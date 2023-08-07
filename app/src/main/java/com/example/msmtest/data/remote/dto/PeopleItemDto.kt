package com.example.msmtest.data.remote.dto


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.msmtest.domain.model.PeopleItemModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = "People")
data class PeopleItemDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @SerializedName("avatarImage")
    val avatarImage: String?,

    @ColumnInfo(name = "dateOfBirth")
    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,

    @SerializedName("firstName")
    val firstName: String?,

    @ColumnInfo(name = "lastName")
    @SerializedName("lastName")
    val lastName: String?,

    @ColumnInfo(name = "role")
    @SerializedName("role")
    val role: String?
) {
    constructor(
    ) : this(
        0,
        null,
        null,
        null,
        null,
        null
    )
}

fun PeopleItemDto.toPeopleItem(): PeopleItemModel {
    return PeopleItemModel(
        avatarImage = avatarImage.orEmpty(),
        dateOfBirth = dateOfBirth.orEmpty(),
        firstName = firstName.orEmpty(),
        lastName = lastName.orEmpty(),
        role = role.orEmpty()
    )
}