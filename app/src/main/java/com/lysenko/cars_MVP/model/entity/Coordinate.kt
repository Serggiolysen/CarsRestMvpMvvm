package com.lysenko.cars_MVP.model.entity

import com.google.gson.annotations.SerializedName

data class Coordinate(

    @SerializedName("latitude")
    val latitude: Double,

    @SerializedName("longitude")
    val longitude: Double
)