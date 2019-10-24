package com.lysenko.cars_MVP.model.entity

import com.google.gson.annotations.SerializedName


data class Poi(

    @SerializedName("id")
    val id: Int,

    @SerializedName("coordinate")
    val coordinate: Coordinate?,

    @SerializedName("fleetType")
    val fleeType: FleetType?,

    @SerializedName("heading")
    val heading: Double?
)