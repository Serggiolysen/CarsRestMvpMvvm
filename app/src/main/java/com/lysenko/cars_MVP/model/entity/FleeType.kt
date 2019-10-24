package com.lysenko.cars_MVP.model.entity

import com.google.gson.annotations.SerializedName

enum class FleetType {

    @SerializedName("TAXI")
    TAXI,

    @SerializedName("POOLING")
    POOLING
}