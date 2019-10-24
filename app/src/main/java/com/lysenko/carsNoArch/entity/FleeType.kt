package com.lysenko.carsNoArch.entity

import com.google.gson.annotations.SerializedName

enum class FleetType {

    @SerializedName("TAXI")
    TAXI,

    @SerializedName("POOLING")
    POOLING
}