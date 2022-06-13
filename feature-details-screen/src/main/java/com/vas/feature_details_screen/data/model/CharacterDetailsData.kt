package com.vas.feature_details_screen.data.model

import com.google.gson.annotations.SerializedName

data class CharacterDetailsData (
    @SerializedName("Name")
    val name: String,

    @SerializedName("Image")
    val urlIcon: String,

    @SerializedName("Character Type")
    val characterType: String?,

    @SerializedName("Powers")
    val powers: String?,
)