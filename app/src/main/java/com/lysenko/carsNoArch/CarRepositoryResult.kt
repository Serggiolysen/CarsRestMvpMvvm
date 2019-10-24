package com.lysenko.carsNoArch

import com.lysenko.carsNoArch.entity.Poi

interface CarRepositoryResult {
    fun onSuccess(list: List<Poi>)
    fun onError(throwable: Throwable)
}

interface SelectCarInterface{
    fun select(item: Poi)
}