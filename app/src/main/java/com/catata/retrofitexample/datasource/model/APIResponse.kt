package com.catata.retrofitexample.datasource.model

import com.google.gson.annotations.SerializedName

data class APIResponse(
    val info: Info,
    @SerializedName(value = "results")
    val characters: List<CharacterInfo>
)