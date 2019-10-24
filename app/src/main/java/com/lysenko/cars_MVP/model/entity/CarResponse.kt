package com.lysenko.cars_MVP.model.entity

import com.google.gson.annotations.SerializedName

data class CarResponse(

    @SerializedName("poiList")
    val poiList: List<Poi>
)